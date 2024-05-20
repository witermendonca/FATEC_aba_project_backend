CREATE TABLE IF NOT EXISTS client(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    gender VARCHAR(20) NOT NULL,
    cpf VARCHAR(20) UNIQUE NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    education_level VARCHAR(255),
    medical_informations VARCHAR(255),
    medicines_in_use VARCHAR(255),
    processing_information VARCHAR(255),
    cep VARCHAR(20) NOT NULL,
    street VARCHAR(100) NOT NULL,
    address_number INT NOT NULL,
    complement VARCHAR(100),
    neighborhood VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS responsible(
    id BIGSERIAL PRIMARY KEY,
    client_id BIGINT,
    name VARCHAR(100) NOT NULL,
    cpf VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    degree_of_kinship VARCHAR(100) NOT NULL,
    telephone VARCHAR(20) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS protocol(
    id BIGSERIAL PRIMARY KEY,
    client_id BIGINT,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100) NOT NULL,
    FOREIGN KEY (client_id) REFERENCES client(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS applications (
    id BIGSERIAL PRIMARY KEY,
    positive_percentage DOUBLE PRECISION,
    success INTEGER,
    failure INTEGER,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    aborted BOOLEAN,
    reason_abortion VARCHAR(255),
    protocol_id BIGINT,
    FOREIGN KEY (protocol_id) REFERENCES protocol(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS attempts (
    id BIGSERIAL PRIMARY KEY,
    help VARCHAR(255),
    comments VARCHAR(255),
    attempt_number INTEGER,
    result BOOLEAN,
    application_id BIGINT,
    FOREIGN KEY (application_id) REFERENCES applications(id) ON DELETE CASCADE
);