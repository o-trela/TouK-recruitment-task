INSERT INTO Movie(id, title, duration_time) VALUES (1, 'Batman', 176);
INSERT INTO Movie(id, title, duration_time) VALUES (2, 'Uncharted', 116);
INSERT INTO Movie(id, title, duration_time) VALUES (3, 'Spider-Man: No way home', 148);

INSERT INTO Room(id, no_seats) VALUES (1, 150);
INSERT INTO Room(id, no_seats) VALUES (2, 130);
INSERT INTO Room(id, no_seats) VALUES (3, 135);

INSERT INTO Screening(id, start_time, id_movie, id_room) VALUES (1, '2022-04-29T16:00:00', 1, 1);
INSERT INTO Screening(id, start_time, id_movie, id_room) VALUES (2, '2022-04-20T13:00:00', 2, 1);
INSERT INTO Screening(id, start_time, id_movie, id_room) VALUES (3, '2022-04-18T10:00:00', 1, 3);
INSERT INTO Screening(id, start_time, id_movie, id_room) VALUES (4, '2022-04-27T20:00:00', 3, 2);
INSERT INTO Screening(id, start_time, id_movie, id_room) VALUES (5, '2022-04-27T21:00:00', 2, 3);
INSERT INTO Screening(id, start_time, id_movie, id_room) VALUES (6, '2022-04-27T21:00:00', 3, 3);

INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (1, 1, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (2, 1, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (3, 1, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (4, 1, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (5, 1, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (6, 1, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (7, 1, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (8, 1, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (9, 1, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (10, 1, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (11, 2, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (12, 2, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (13, 2, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (14, 2, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (15, 2, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (16, 2, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (17, 2, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (18, 2, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (19, 2, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (20, 2, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (21, 3, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (22, 3, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (23, 3, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (24, 3, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (25, 3, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (26, 3, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (27, 3, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (28, 3, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (29, 3, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (30, 3, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (31, 4, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (32, 4, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (33, 4, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (34, 4, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (35, 4, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (36, 4, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (37, 4, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (38, 4, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (39, 4, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (40, 4, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (41, 5, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (42, 5, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (43, 5, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (44, 5, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (45, 5, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (46, 5, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (47, 5, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (48, 5, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (49, 5, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (50, 5, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (51, 6, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (52, 6, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (53, 6, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (54, 6, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (55, 6, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (56, 6, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (57, 6, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (58, 6, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (59, 6, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (60, 6, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (61, 7, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (62, 7, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (63, 7, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (64, 7, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (65, 7, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (66, 7, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (67, 7, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (68, 7, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (69, 7, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (70, 7, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (71, 8, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (72, 8, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (73, 8, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (74, 8, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (75, 8, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (76, 8, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (77, 8, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (78, 8, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (79, 8, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (80, 8, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (81, 9, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (82, 9, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (83, 9, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (84, 9, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (85, 9, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (86, 9, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (87, 9, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (88, 9, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (89, 9, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (90, 9, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (91, 10, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (92, 10, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (93, 10, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (94, 10, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (95, 10, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (96, 10, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (97, 10, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (98, 10, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (99, 10, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (100, 10, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (101, 11, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (102, 11, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (103, 11, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (104, 11, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (105, 11, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (106, 11, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (107, 11, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (108, 11, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (109, 11, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (110, 11, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (111, 12, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (112, 12, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (113, 12, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (114, 12, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (115, 12, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (116, 12, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (117, 12, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (118, 12, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (119, 12, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (120, 12, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (121, 13, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (122, 13, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (123, 13, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (124, 13, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (125, 13, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (126, 13, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (127, 13, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (128, 13, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (129, 13, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (130, 13, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (131, 14, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (132, 14, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (133, 14, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (134, 14, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (135, 14, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (136, 14, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (137, 14, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (138, 14, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (139, 14, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (140, 14, 10, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (141, 15, 1, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (142, 15, 2, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (143, 15, 3, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (144, 15, 4, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (145, 15, 5, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (146, 15, 6, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (147, 15, 7, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (148, 15, 8, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (149, 15, 9, 1);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (150, 15, 10, 1);

INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (151, 1, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (152, 1, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (153, 1, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (154, 1, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (155, 1, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (156, 1, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (157, 1, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (158, 1, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (159, 1, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (160, 1, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (161, 2, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (162, 2, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (163, 2, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (164, 2, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (165, 2, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (166, 2, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (167, 2, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (168, 2, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (169, 2, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (170, 2, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (171, 3, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (172, 3, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (173, 3, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (174, 3, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (175, 3, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (176, 3, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (177, 3, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (178, 3, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (179, 3, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (180, 3, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (181, 4, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (182, 4, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (183, 4, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (184, 4, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (185, 4, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (186, 4, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (187, 4, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (188, 4, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (189, 4, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (190, 4, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (191, 5, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (192, 5, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (193, 5, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (194, 5, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (195, 5, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (196, 5, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (197, 5, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (198, 5, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (199, 5, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (200, 5, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (201, 6, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (202, 6, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (203, 6, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (204, 6, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (205, 6, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (206, 6, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (207, 6, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (208, 6, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (209, 6, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (210, 6, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (211, 7, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (212, 7, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (213, 7, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (214, 7, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (215, 7, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (216, 7, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (217, 7, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (218, 7, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (219, 7, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (220, 7, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (221, 8, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (222, 8, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (223, 8, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (224, 8, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (225, 8, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (226, 8, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (227, 8, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (228, 8, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (229, 8, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (230, 8, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (231, 9, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (232, 9, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (233, 9, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (234, 9, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (235, 9, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (236, 9, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (237, 9, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (238, 9, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (239, 9, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (240, 9, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (241, 10, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (242, 10, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (243, 10, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (244, 10, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (245, 10, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (246, 10, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (247, 10, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (248, 10, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (249, 10, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (250, 10, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (251, 11, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (252, 11, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (253, 11, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (254, 11, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (255, 11, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (256, 11, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (257, 11, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (258, 11, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (259, 11, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (260, 11, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (261, 12, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (262, 12, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (263, 12, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (264, 12, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (265, 12, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (266, 12, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (267, 12, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (268, 12, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (269, 12, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (270, 12, 10, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (271, 13, 1, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (272, 13, 2, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (273, 13, 3, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (274, 13, 4, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (275, 13, 5, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (276, 13, 6, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (277, 13, 7, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (278, 13, 8, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (279, 13, 9, 2);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (280, 13, 10, 2);

INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (281, 1, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (282, 1, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (283, 1, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (284, 1, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (285, 1, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (286, 1, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (287, 1, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (288, 1, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (289, 1, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (290, 1, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (291, 2, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (292, 2, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (293, 2, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (294, 2, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (295, 2, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (296, 2, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (297, 2, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (298, 2, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (299, 2, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (300, 2, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (301, 3, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (302, 3, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (303, 3, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (304, 3, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (305, 3, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (306, 3, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (307, 3, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (308, 3, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (309, 3, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (310, 3, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (311, 4, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (312, 4, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (313, 4, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (314, 4, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (315, 4, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (316, 4, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (317, 4, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (318, 4, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (319, 4, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (320, 4, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (321, 5, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (322, 5, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (323, 5, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (324, 5, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (325, 5, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (326, 5, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (327, 5, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (328, 5, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (329, 5, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (330, 5, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (331, 6, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (332, 6, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (333, 6, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (334, 6, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (335, 6, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (336, 6, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (337, 6, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (338, 6, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (339, 6, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (340, 6, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (341, 7, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (342, 7, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (343, 7, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (344, 7, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (345, 7, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (346, 7, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (347, 7, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (348, 7, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (349, 7, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (350, 7, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (351, 8, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (352, 8, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (353, 8, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (354, 8, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (355, 8, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (356, 8, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (357, 8, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (358, 8, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (359, 8, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (360, 8, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (361, 9, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (362, 9, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (363, 9, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (364, 9, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (365, 9, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (366, 9, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (367, 9, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (368, 9, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (369, 9, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (370, 9, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (371, 10, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (372, 10, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (373, 10, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (374, 10, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (375, 10, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (376, 10, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (377, 10, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (378, 10, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (379, 10, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (380, 10, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (381, 11, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (382, 11, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (383, 11, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (384, 11, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (385, 11, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (386, 11, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (387, 11, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (388, 11, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (389, 11, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (390, 11, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (391, 12, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (392, 12, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (393, 12, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (394, 12, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (395, 12, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (396, 12, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (397, 12, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (398, 12, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (399, 12, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (400, 12, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (401, 13, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (402, 13, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (403, 13, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (404, 13, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (405, 13, 5, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (406, 13, 6, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (407, 13, 7, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (408, 13, 8, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (409, 13, 9, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (410, 13, 10, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (411, 14, 1, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (412, 14, 2, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (413, 14, 3, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (414, 14, 4, 3);
INSERT INTO Seat(id, row_num, seat_num, id_room) VALUES (415, 14, 5, 3);

INSERT INTO Reservation(id, name, surname, id_screening) VALUES (1, 'Oscar', 'Wilde', 2);
INSERT INTO Reservation(id, name, surname, id_screening) VALUES (2, 'Beth', 'Brown', 1);
INSERT INTO Reservation(id, name, surname, id_screening) VALUES (3, 'Jacob', 'Buck', 2);
INSERT INTO Reservation(id, name, surname, id_screening) VALUES (4, 'Tessa', 'Violet', 3);

INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (1, 1, 45, 1, 2);
INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (2, 3, 46, 1, 2);
INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (3, 1, 47, 1, 2);
INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (4, 2, 55, 2, 1);
INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (5, 1, 143, 3, 2);
INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (6, 1, 142, 3, 2);
INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (7, 2, 394, 4, 3);
INSERT INTO Ticket(id, ticket_type, id_seat, id_reservation, id_screening) VALUES (8, 2, 395, 4, 3);

