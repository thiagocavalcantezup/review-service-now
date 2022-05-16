CREATE TABLE usuario_notebooks (
  usuario_id BIGINT NOT NULL,
  notebooks VARCHAR(255),
  notebooks_key INTEGER NOT NULL,
  PRIMARY KEY (usuario_id, notebooks_key)
)
