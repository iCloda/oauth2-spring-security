CREATE TABLE bmape.oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BYTEA,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BYTEA,
  refresh_token VARCHAR(256) DEFAULT NULL
);

CREATE TABLE bmape.oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BYTEA,
  authentication BYTEA
);