-- Insertar Intersecciones
INSERT INTO intersection (location, code, latitude, longitude) VALUES ('Calle 10 con Carrera 15', 'INT001', 6.2518, -75.5636);
INSERT INTO intersection (location, code, latitude, longitude) VALUES ('Calle 50 con Carrera 30', 'INT002', 4.6097, -74.0817);

-- Insertar Semáforos para la primera intersección (INT001)
INSERT INTO traffic_light (direction, intersection_id) VALUES ('WE', 1);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('EW', 1);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('NS', 1);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('SN', 1);

-- Insertar Semáforos para la segunda intersección (INT002)
INSERT INTO traffic_light (direction, intersection_id) VALUES ('WE', 2);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('EW', 2);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('NS', 2);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('SN', 2);

-- 1) Insertar Users para Caregivers
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Laura', 'Marcela', 'Gómez', 'Pérez', 'laura.gomez@example.com', 'pass123', '3001111111');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Carlos', NULL, 'Ramírez', 'Torres', 'carlos.ramirez@example.com', 'pass123', '3002222222');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Ana', 'Lucía', 'Martínez', NULL, 'ana.martinez@example.com', 'pass123', '3003333333');

-- 2) Insertar Caregivers
INSERT INTO caregiver (id, address) VALUES (1, 'Calle 10 #20-30');
INSERT INTO caregiver (id, address) VALUES (2, 'Carrera 15 #40-22');
INSERT INTO caregiver (id, address) VALUES (3, 'Avenida 80 #55-10');

-- 3) Insertar Users para Patients
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Juan', 'Esteban', 'Pérez', 'López', 'juan.perez@example.com', 'pass123', '3011111111');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('María', NULL, 'Ramírez', 'García', 'maria.ramirez@example.com', 'pass123', '3012222222');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Andrés', 'Felipe', 'Martínez', 'Suárez', 'andres.martinez@example.com', 'pass123', '3013333333');

-- 4) Insertar Discapacidades
INSERT INTO disability (id, name, description) VALUES (1, 'Discapacidad visual', 'Pérdida parcial o total de la visión');
INSERT INTO disability (id, name, description) VALUES (2, 'Discapacidad auditiva', 'Pérdida parcial o total de la audición');
INSERT INTO disability (id, name, description) VALUES (3, 'Movilidad reducida', 'Limitaciones para desplazarse físicamente');

-- 5) Insertar Patients asociados a sus Caregivers y Discapacidades
INSERT INTO patient (id, address, disability_id, caregiver_id) VALUES (4, 'Calle 50 #12-20', 1, 1);
INSERT INTO patient (id, address, disability_id, caregiver_id) VALUES (5, 'Carrera 70 #45-15', 2, 2);
INSERT INTO patient (id, address, disability_id, caregiver_id) VALUES (6, 'Avenida 30 #10-05', 3, 3);

-- 6) Insertar Users para Employees
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Pedro', NULL, 'Salazar', 'López', 'pedro.salazar@example.com', 'adminPass123', '3021111111');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Lucía', NULL, 'Fernández', 'García', 'lucia.fernandez@example.com', 'operatorPass123', '3022222222');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Mateo', NULL, 'Rodríguez', 'Santos', 'mateo.rodriguez@example.com', 'operatorPass456', '3023333333');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Camila', NULL, 'Jiménez', 'Rojas', 'camila.jimenez@example.com', 'adminPass456', '3024444444');
INSERT INTO user (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Sofía', NULL, 'Gómez', 'Pérez', 'sofia.gomez@example.com', 'operatorPass789', '3025555555');

-- 7) Insertar Employees (IDs de los Users 7-11)
INSERT INTO employee (id, role) VALUES (7, 'ADMIN');
INSERT INTO employee (id, role) VALUES (8, 'OPERATOR');
INSERT INTO employee (id, role) VALUES (9, 'OPERATOR');
INSERT INTO employee (id, role) VALUES (10, 'ADMIN');
INSERT INTO employee (id, role) VALUES (11, 'OPERATOR');

INSERT INTO card (rfid_code, issued_at, status, patient_id) VALUES ('AAD4B015', NOW(), 'ACTIVE', 4);
INSERT INTO card (rfid_code, issued_at, status, patient_id) VALUES ('14B0B02B', NOW(), 'ACTIVE', 5);
INSERT INTO card (rfid_code, issued_at, status, patient_id) VALUES ('RFID-1003', NOW(), 'ACTIVE', 6);

