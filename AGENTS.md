# AGENTS.md

Spring Boot 4.0.5 / Java 26 REST app (group `org.recolo:samthedog`, entrypoint `org.recolo.AppMain`) that OAuth1-authenticates against the E*Trade API (ScribeJava) and exposes market-data endpoints as CSV.

## Build & run (JDK 26 + Maven required; no wrapper)
- Build: `mvn package` · Run: `mvn spring-boot:run` (port 8080)
- `consumer.key` / `consumer.secret` have no defaults — the app fails to start without them. Pass as JVM args:
  `mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dconsumer.key=... -Dconsumer.secret=..."`
- `base.url` selects prod (`https://api.etrade.com`). `sandbox.base.url` is defined but NOT wired up — switching to sandbox means editing `base.url`, and `ETradeServiceApi#getRequestTokenEndpoint` (src/main/java/org/recolo/oauth/ETradeServiceApi.java:19) is hardcoded to `api.etrade.com` regardless.

## OAuth flow (prerequisite for data endpoints)
- `GET /login` → authorize in browser → submit PIN to `POST /callback`.
- Access token is Java-serialized to `<accessTokenCachePath>/Access.token` (default: working dir; gitignored). Delete it to force re-auth — stale tokens 401 the market-data calls.

## Endpoints (text/csv)
- `GET /quote?symbol=QQQ` — current quote
- `GET /optionChain?symbol=QQQ` — full option chain
- `GET /optionsByStrike?symbol=QQQ&strike=...&optionType=Call` — every expiration for the nearest strike

## Tests
- `mvn test`. `ParquetTest` (src/test/java/org/recolo/ParquetTest.java:27) hardcodes `Path` `/Users/alan/Downloads/options_QQQ_1m.parquet` — tests fail without that file on disk.
- `src/test/java/org/recolo/ETradeOptionsApp.java` contains real E*Trade consumer key/secret and is gitignored via the nested `.gitignore`. Never commit real credentials or `src/test/` secrets.

## Gotchas
- Log4j2 rolls `application.log` → `ETradeMarketDataService-YYYY-MM-DD.log` in the working dir (gitignored). `mvn test` also writes `target/surefire-reports`.
- Code uses legacy/typo naming (`getCloestOption`, `qoute`, `exiration`) — preserve when editing, don't "fix" incidentally.
- Log-level strings inside `String.format` in the controller use logback-style `{}` placeholders (render as literal `{}` in CSV) — pre-existing quirk.