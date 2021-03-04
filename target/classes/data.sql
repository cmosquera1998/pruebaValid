DROP TABLE IF EXISTS registro;

CREATE TABLE registro (
  id_Registro INT AUTO_INCREMENT  PRIMARY KEY,
  nombre VARCHAR(250) NOT NULL,
  apellido VARCHAR(250) NOT NULL,
  procesado BOOLEAN DEFAULT false
);


