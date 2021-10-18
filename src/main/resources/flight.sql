SELECT Flight.flight_id, SourceAirport.airport_name SourceAirport, DestAirport.airport_name DestinationAirport
FROM
    tbl_flight Flight
        JOIN tbl_airport SourceAirport
             ON SourceAirport.airport_id = Flight.fk_source
        JOIN tbl_airport DestAirport
             ON DestAirport.airport_id = Flight.fk_destination
WHERE
        Flight.date = '2021-12-15'