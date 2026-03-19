-- =====================
-- TABLE ROLE
-- =====================
CREATE TABLE role (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(20) NOT NULL UNIQUE
);

-- =====================
-- TABLE DEPARTMENT
-- =====================
CREATE TABLE departement (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

-- =====================
-- TABLE USERS (éviter "user" car réservé)
-- =====================
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(150) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    is_active BOOLEAN DEFAULT TRUE,
    role_id BIGINT,
    department_id BIGINT,

    CONSTRAINT fk_user_role
        FOREIGN KEY (role_id)
        REFERENCES role(id)
        ON DELETE SET NULL,

    CONSTRAINT fk_user_department
        FOREIGN KEY (department_id)
        REFERENCES department(id)
        ON DELETE SET NULL
);

-- =====================
-- TABLE ABSENCE
-- =====================
CREATE TABLE absence (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    type VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,

    CONSTRAINT fk_absence_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);

-- =====================
-- AJOUT CONTRAINTES CHECK (optionnel mais recommandé)
-- =====================
ALTER TABLE absence
ADD CONSTRAINT chk_absence_type
CHECK (type IN ('VACATION', 'SICK', 'RTT'));

ALTER TABLE absence
ADD CONSTRAINT chk_absence_status
CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED'));