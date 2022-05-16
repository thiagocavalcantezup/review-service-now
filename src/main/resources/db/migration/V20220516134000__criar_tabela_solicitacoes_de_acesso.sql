CREATE TABLE solicitacoes_de_acesso (
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  solicitante VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  notebook VARCHAR(255) NOT NULL,
  aprovador VARCHAR(255) NOT NULL,
  pod VARCHAR(255) NOT NULL,
  projeto VARCHAR(255) NOT NULL,
  resposta_pcd VARCHAR(255) NOT NULL,
  em_nome_de VARCHAR(255) NOT NULL,
  tipo_solicitacao VARCHAR(255) NOT NULL,
  funcao VARCHAR(255) NOT NULL
)
