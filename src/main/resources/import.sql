/* Insertar Intersecciones */
INSERT INTO intersection (location, code, latitude, longitude) VALUES ('Calle 10 con Carrera 15', 'INT001', 6.2518, -75.5636);
INSERT INTO intersection (location, code, latitude, longitude) VALUES ('Calle 50 con Carrera 30', 'INT002', 4.6097, -74.0817);

/* Insertar Semáforos para la primera intersección (INT001) */
INSERT INTO traffic_light (direction, intersection_id) VALUES ('WE', 1);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('EW', 1);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('NS', 1);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('SN', 1);

/* Insertar Semáforos para la segunda intersección (INT002) */
INSERT INTO traffic_light (direction, intersection_id) VALUES ('WE', 2);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('EW', 2);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('NS', 2);
INSERT INTO traffic_light (direction, intersection_id) VALUES ('SN', 2);

/* 1) Insertar Users para Caregivers */
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Laura', 'Marcela', 'Gómez', 'Pérez', 'laura.gomez@example.com', 'pass123', '3001111111');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Carlos', NULL, 'Ramírez', 'Torres', 'carlos.ramirez@example.com', 'pass123', '3002222222');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Ana', 'Lucía', 'Martínez', NULL, 'ana.martinez@example.com', 'pass123', '3003333333');

/* 2) Insertar Caregivers */
INSERT INTO caregiver (id, address) VALUES (1, 'Calle 10 #20-30');
INSERT INTO caregiver (id, address) VALUES (2, 'Carrera 15 #40-22');
INSERT INTO caregiver (id, address) VALUES (3, 'Avenida 80 #55-10');

/* 3) Insertar Users para Patients */
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Juan', 'Esteban', 'Pérez', 'López', 'juan.perez@example.com', 'pass123', '3011111111');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('María', NULL, 'Ramírez', 'García', 'maria.ramirez@example.com', 'pass123', '3012222222');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Andrés', 'Felipe', 'Martínez', 'Suárez', 'andres.martinez@example.com', 'pass123', '3013333333');

/* 4) Insertar Discapacidades */
INSERT INTO disability (name, description) VALUES ('Discapacidad visual', 'Pérdida parcial o total de la visión');
INSERT INTO disability (name, description) VALUES ('Discapacidad auditiva', 'Pérdida parcial o total de la audición');
INSERT INTO disability (name, description) VALUES ('Movilidad reducida', 'Limitaciones para desplazarse físicamente');

/* 5) Insertar Patients asociados a sus Caregivers */
INSERT INTO patient (id, address, caregiver_id) VALUES (4,'Calle 50 #12-20', 1);
INSERT INTO patient (id, address, caregiver_id) VALUES (5, 'Carrera 70 #45-15', 2);
INSERT INTO patient (id, address, caregiver_id) VALUES (6, 'Avenida 30 #10-05', 3);

/* 6) Insertar Users para Employees */
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Pedro', NULL, 'Salazar', 'López', 'pedro.salazar@example.com', 'adminPass123', '3021111111');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Lucía', NULL, 'Fernández', 'García', 'lucia.fernandez@example.com', 'operatorPass123', '3022222222');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Mateo', NULL, 'Rodríguez', 'Santos', 'mateo.rodriguez@example.com', 'operatorPass456', '3023333333');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Camila', NULL, 'Jiménez', 'Rojas', 'camila.jimenez@example.com', 'adminPass456', '3024444444');
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Sofía', NULL, 'Gómez', 'Pérez', 'sofia.gomez@example.com', 'operatorPass789', '3025555555');

/* 7) Insertar Employees */
INSERT INTO employee (id, role) VALUES (7, 'ADMIN');
INSERT INTO employee (id, role) VALUES (8, 'OPERATOR');
INSERT INTO employee (id, role) VALUES (9, 'OPERATOR');
INSERT INTO employee (id, role) VALUES (10, 'ADMIN');
INSERT INTO employee (id, role) VALUES (11, 'OPERATOR');

/* 8) Insertar Tarjetas RFID */
INSERT INTO card (rfid_code, issued_at, status, patient_id) VALUES ('AAD4B015', NOW(), 'ACTIVE', 4);
INSERT INTO card (rfid_code, issued_at, status, patient_id) VALUES ('14B0B02B', NOW(), 'ACTIVE', 5);
INSERT INTO card (rfid_code, issued_at, status, patient_id) VALUES ('RFID-1003', NOW(), 'ACTIVE', 6);

/* 9) Insertar relaciones entre pacientes y discapacidades con severidad y notas */
INSERT INTO patient_disability (patient_id, disability_id, severity, notes) VALUES (4, 1, 'HIGH', 'tiene discapacidad visual moderada que afecta su capacidad para leer textos pequeños y distinguir detalles finos. Requiere materiales en formato de alto contraste y puede beneficiarse de herramientas de ampliación de texto. Su visión periférica está limitada, por lo que es importante mantener el entorno organizado y libre de obstáculos.');
INSERT INTO patient_disability (patient_id, disability_id, severity, notes) VALUES (4, 3, 'MEDIUM', 'utiliza silla de ruedas debido a una lesión medular a nivel torácico. Requiere espacios accesibles sin barreras arquitectónicas, rampas y ascensores funcionales. Tiene plena movilidad en miembros superiores y puede realizar todas sus actividades con las adaptaciones adecuadas del entorno.');
INSERT INTO patient_disability (patient_id, disability_id, severity, notes) VALUES (5, 2, 'LOW', 'presenta pérdida auditiva bilateral severa. Utiliza lenguaje de señas como principal medio de comunicación y puede beneficiarse de intérpretes en reuniones. Requiere materiales visuales claros y apoyo con subtítulos en contenido audiovisual. Es importante mantener contacto visual al comunicarse.');
INSERT INTO patient_disability (patient_id, disability_id, severity, notes) VALUES (6, 2, 'MEDIUM', 'tiene hipoacusia neurosensorial bilateral moderada. Utiliza audífonos bilaterales que le permiten comunicarse efectivamente en ambientes con poco ruido. En ambientes ruidosos o reuniones grupales, puede requerir apoyo adicional como sistemas FM o subtítulos.');
INSERT INTO patient_disability (patient_id, disability_id, severity, notes) VALUES (6, 3, 'HIGH', 'presenta artritis reumatoide que ocasionalmente afecta su movilidad fina en las manos. Puede requerir herramientas adaptadas para escritura o trabajo con ordenadores durante periodos de inflamación aguda.');


/* 10) Nuevos pacientes con múltiples discapacidades */
INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Santiago', 'David', 'Torres', 'Quintero', 'santiago.torres@example.com', 'pass123', '3014444444');
INSERT INTO patient (id, address, caregiver_id) VALUES (12,'Calle 25 #9-88', 1);
INSERT INTO patient_disability (patient_id, disability_id) VALUES (12, 1);
INSERT INTO patient_disability (patient_id, disability_id) VALUES (12, 2);

INSERT INTO `user` (first_name, second_name, first_last_name, second_last_name, email, password, phone) VALUES ('Valentina', 'Sofía', 'Mendoza', 'Ruiz', 'valentina.mendoza@example.com', 'pass123', '3015555555');
INSERT INTO patient (id, address, caregiver_id) VALUES (13, 'Carrera 45 #21-33', 2);
INSERT INTO patient_disability (patient_id, disability_id) VALUES (13, 1);
INSERT INTO patient_disability (patient_id, disability_id) VALUES (13, 2);
INSERT INTO patient_disability (patient_id, disability_id) VALUES (13, 3);


/* Transacciones */
INSERT INTO `Transaction` (created_at, status, description, patient_id, intersection_id) VALUES ('2025-11-14 06:00:00', 'COMPLETED', 'Transacción recibida y validada', 13, 1);
