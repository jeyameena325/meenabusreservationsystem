INSERT INTO bus_details(id,bus_number,source_city,destination_city,travel_date,return_date,bus_operator_name,bus_departure_time,bus_arrival_time,total_duration,fare) VALUES 
  (1,'TN24T0511','Chennai','Bengaluru', '2019-07-07','2019-07-07','ABC Travels','12:00','14:00', 1,600),
  (2,'KA23S0306','Madurai','Chennai', '2019-08-08','2019-08-08','CDE Travels','09:00','16:00', 2, 950),
  (3,'KL21A0314','Madurai','Bengaluru', '2019-09-12','2019-09-12','FGH Travels','10:00','18:30', 2.30,1400);
  
  INSERT INTO seat_reservation_details(seat_id,bus_number,seat_number,user_id,is_booked,fare) VALUES 
  (1,'TN24T0511',1,1,true,290),(6,'KA23S0306',2,2,true,1000),(11,'KL21A0314',3,3,true,1400);
  
  INSERT INTO seat_reservation_details(seat_id,bus_number,seat_number,is_booked) VALUES 
 (2,'TN24T0511',2,false),(3,'TN24T0511',3,false),(4,'TN24T0511',4,false),
  (5,'KA23S0306',1,false),(7,'KA23S0306',3,false),(8,'KA23S0306',4,false),
  (9,'KL21A0314',1,false),(10,'KL21A0314',2,false),(12,'KL21A0314',4,false);
  
