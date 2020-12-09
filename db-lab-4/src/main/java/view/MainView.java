package view;

import controller.implementation.*;
import model.implementation.*;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private static final Scanner INPUT = new Scanner(System.in);
    private final AirlineController airlineController = new AirlineController();
    private final AirportController airportController = new AirportController();
    private final BookingController bookingController = new BookingController();
    private final ClientController clientController = new ClientController();
    private final CurrentInfoAboutThePlaneController currentInfoAboutThePlaneController = new CurrentInfoAboutThePlaneController();
    private final FlightController flightController = new FlightController();
    private final InfoClientController infoClientController = new InfoClientController();
    private final PaymentBookingController paymentBookingController = new PaymentBookingController();
    private final PlaneInfoController planeInfoController = new PlaneInfoController();
    private final RegistrationInfoController registrationInfoController = new RegistrationInfoController();
    private final RouteController routeController = new RouteController();
    private final ScheduleController scheduleController = new ScheduleController();
    private final TicketController ticketController = new TicketController();
    private final TravelClassController travelClassController = new TravelClassController();


    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;

    public MainView(Session session) throws SQLException {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("11", "11 - Get all airlines");
        menu.put("12", "12 - Get airline by ID");
        menu.put("13", "13 - Create airline");
        menu.put("14", "14 - Delete airline by ID");
        menu.put("15", "15 - Update airline by ID");

        menu.put("21", "21 - Get all airports");
        menu.put("22", "22 - Get airport by ID");
        menu.put("23", "23 - Create airport");
        menu.put("24", "24 - Delete airport by ID");
        menu.put("25", "25 - Update airport by ID");

        menu.put("31", "31 - Get all bookings");
        menu.put("32", "32 - Get booking by ID");
        menu.put("33", "33 - Create booking");
        menu.put("34", "34 - Delete booking by ID");
        menu.put("35", "35 - Update booking by ID");

        menu.put("41", "41 - Get all clients");
        menu.put("42", "42 - Get client by ID");
        menu.put("43", "43 - Create client");
        menu.put("44", "44 - Delete client by ID");
        menu.put("45", "45 - Update client by ID");

        menu.put("51", "51 - Get all current info about the planes");
        menu.put("52", "52 - Get current info about the plane by ID");
        menu.put("53", "53 - Create current info about the plane");
        menu.put("54", "54 - Delete current info about the plane by ID");
        menu.put("55", "55 - Update current info about the plane  by ID");

        menu.put("61", "61 - Get all flights");
        menu.put("62", "62 - Get flight by ID");
        menu.put("63", "63 - Create flight");
        menu.put("64", "64 - Delete flight by ID");
        menu.put("65", "65 - Update flight by ID");

        menu.put("71", "71 - Get all info clients");
        menu.put("72", "72 - Get info client by ID");
        menu.put("73", "73 - Create info client");
        menu.put("74", "74 - Delete info client by ID");
        menu.put("75", "75 - Update info client by ID");

        menu.put("81", "81 - Get all payment bookings");
        menu.put("82", "82 - Get payment booking by ID");
        menu.put("83", "83 - Create payment booking");
        menu.put("84", "84 - Delete payment booking by ID");
        menu.put("85", "85 - Update payment booking by ID");

        menu.put("91", "91 - Get all info planes");
        menu.put("92", "92 - Get info plane by ID");
        menu.put("93", "93 - Create info plane");
        menu.put("94", "94 - Delete info plane by ID");
        menu.put("95", "95 - Update info plane by ID");

        menu.put("101", "101 - Get all registration info");
        menu.put("102", "102 - Get registration info by ID");
        menu.put("103", "103 - Create registration info");
        menu.put("104", "104 - Delete registration info by ID");
        menu.put("105", "105 - Update registration info by ID");

        menu.put("111", "111 - Get all routes");
        menu.put("112", "112 - Get route by ID");
        menu.put("113", "113 - Create route");
        menu.put("114", "114 - Delete route by ID");
        menu.put("115", "115 - Update route by ID");

        menu.put("121", "121 - Get all schedules");
        menu.put("122", "122 - Get schedule by ID");
        menu.put("123", "123 - Create schedule");
        menu.put("124", "124 - Delete schedule by ID");
        menu.put("125", "125 - Update schedule by ID");

        menu.put("131", "131 - Get all tickets");
        menu.put("132", "132 - Get ticket by ID");
        menu.put("133", "133 - Create ticket");
        menu.put("134", "134 - Delete ticket by ID");
        menu.put("135", "135 - Update ticket by ID");

        menu.put("141", "141 - Get all travel classes");
        menu.put("142", "142 - Get travel class by ID");
        menu.put("143", "143 - Create travel class");
        menu.put("144", "144 - Delete travel class by ID");
        menu.put("145", "145 - Update travel class by ID");

        methodsMenu.put("11", ()-> getAllAirlines(session));
        methodsMenu.put("12", () -> getAirlineById(session));
        methodsMenu.put("13", () -> createAirline(session));
        methodsMenu.put("14", () -> deleteAirlineById(session));
        methodsMenu.put("15", () -> updateAirlineById(session));

        methodsMenu.put("21", () -> getAllAirports(session));
        methodsMenu.put("22", () -> getAirportById(session));
        methodsMenu.put("23", () -> createAirport(session));
        methodsMenu.put("24", () -> deleteAirportById(session));
        methodsMenu.put("25", () -> updateAirportById(session));

        methodsMenu.put("31", () -> getAllBookings(session));
        methodsMenu.put("32", () -> getBookingById(session));
        methodsMenu.put("33", () -> createBooking(session));
        methodsMenu.put("34", () -> deleteBookingById(session));
        methodsMenu.put("35", () -> updateBookingById(session));

        methodsMenu.put("41", () -> getAllClients(session));
        methodsMenu.put("42", () -> getClientById(session));
        methodsMenu.put("43", () -> createClient(session));
        methodsMenu.put("44", () -> deleteClientById(session));
        methodsMenu.put("45", () -> updateClientById(session));

        methodsMenu.put("51", () -> getAllInfoAboutThePlanes(session));
        methodsMenu.put("52", () -> getInfoAboutThePlaneById(session));
        methodsMenu.put("53", () -> createInfoAboutThePlane(session));
        methodsMenu.put("54", () -> deleteInfoAboutThePlaneById(session));
        methodsMenu.put("55", () -> updateInfoAboutThePlaneById(session));

        methodsMenu.put("61", () -> getAllFlights(session));
        methodsMenu.put("62", () -> getFlightById(session));
        methodsMenu.put("63", () -> createFlight(session));
        methodsMenu.put("64", () -> deleteFlightById(session));
        methodsMenu.put("65", () -> updateAirlineById(session));

        methodsMenu.put("71", () -> getAllInfoClients(session));
        methodsMenu.put("72", () -> getInfoClientById(session));
        methodsMenu.put("73", () -> createInfoClient(session));
        methodsMenu.put("74", () -> deleteInfoClientById(session));
        methodsMenu.put("75", () -> updateInfoClientById(session));

        methodsMenu.put("81", () -> getAllPaymentBookings(session));
        methodsMenu.put("82", () -> getPaymentBookingById(session));
        methodsMenu.put("83", () -> createPaymentBooking(session));
        methodsMenu.put("84", () -> deletePaymentBookingById(session));
        methodsMenu.put("85", () -> updatePaymentBookingById(session));

        methodsMenu.put("91", () -> getAllPlaneInfos(session));
        methodsMenu.put("92", () -> getPlaneInfoById(session));
        methodsMenu.put("93", () -> createPlaneInfo(session));
        methodsMenu.put("94", () -> deletePlaneInfoById(session));
        methodsMenu.put("95", () -> updatePlaneInfoById(session));

        methodsMenu.put("101", () -> getAllRegistrationInfos(session));
        methodsMenu.put("102", () -> getRegistrationInfoById(session));
        methodsMenu.put("103", () -> createRegistrationInfo(session));
        methodsMenu.put("104", () -> deleteRegistrationInfoById(session));
        methodsMenu.put("105", () -> updateRegistrationInfoById(session));

        methodsMenu.put("111", () -> getAllRoutes(session));
        methodsMenu.put("112", () -> getRouteById(session));
        methodsMenu.put("113", () -> createRoute(session));
        methodsMenu.put("114", () -> deleteRouteById(session));
        methodsMenu.put("115", () -> updateRegistrationInfoById(session));

        methodsMenu.put("121", () -> getAllSchedules(session));
        methodsMenu.put("122", () -> getScheduleById(session));
        methodsMenu.put("123", () -> createSchedule(session));
        methodsMenu.put("124", () -> deleteScheduleById(session));
        methodsMenu.put("125", () -> updateScheduleById(session));

        methodsMenu.put("131", () -> getAllTickets(session));
        methodsMenu.put("132", () -> getTicketById(session));
        methodsMenu.put("133", () -> createTicket(session));
        methodsMenu.put("134", () -> deleteTicketById(session));
        methodsMenu.put("135", () -> updateTicketById(session));

        methodsMenu.put("141", () -> getAllTravelClasses(session));
        methodsMenu.put("142", () -> getTravelClassById(session));
        methodsMenu.put("143", () -> createTravelClass(session));
        methodsMenu.put("144", () -> deleteTravelClassById(session));
        methodsMenu.put("145", () -> updateTravelClassById(session));

    }


    private void getAllAirlines(Session session) throws SQLException {
        System.out.println("\nTable: airline");
        airlineController.getAll(session);
    }

    private void getAirlineById(Session session) throws SQLException {
        System.out.println("Enter ID for Airline: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airlineController.getById(id, session);
    }

    private void createAirline(Session session) throws SQLException {
        System.out.println("Enter new airline name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new airline country: ");
        String country = INPUT.nextLine();
        INPUT.nextLine();
        Airline entity = new Airline(0, name, country);
        airlineController.create(entity, session);
    }

    private void deleteAirlineById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Airline: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airlineController.delete(id, session);
    }

    private void updateAirlineById(Session session) throws SQLException {
        System.out.println("Enter airline id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Airline oldAirline = airlineController.getService().getById(id, session);
        System.out.println("Enter new name for airline: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new country for airline: ");
        String country = INPUT.nextLine();
        INPUT.nextLine();

        String newName = name;
        String newCountry = country;

        if (name.equals("")) newName = oldAirline.getName();
        if (country.equals("")) newCountry = oldAirline.getCountry();

        Airline entity = new Airline(id, newName, newCountry );
        airlineController.update(entity, session);
    }


    private void getAllAirports(Session session) throws SQLException {
        System.out.println("\nTable: airport");
        airportController.getAll(session);
    }

    private void getAirportById(Session session) throws SQLException {
        System.out.println("Enter ID for Airport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airportController.getById(id, session);
    }

    private void createAirport(Session session) throws SQLException {
        System.out.println("Enter new airport city: ");
        String city = INPUT.nextLine();
        System.out.println("Enter new airport name: ");
        String name = INPUT.nextLine();
        INPUT.nextLine();
        Airport entity = new Airport(0, city, name);
        airportController.create(entity, session);
    }

    private void deleteAirportById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Airport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airportController.delete(id, session);
    }

    private void updateAirportById(Session session) throws SQLException {
        System.out.println("Enter airport id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Airport oldAirport = airportController.getService().getById(id, session);
        System.out.println("Enter new city for airport: ");
        String city = INPUT.nextLine();
        System.out.println("Enter new name for airport: ");
        String name = INPUT.nextLine();
        INPUT.nextLine();

        String newCity = city;
        String newName = name;

        if (city.equals("")) newCity = oldAirport.getCity();
        if (name.equals("")) newName = oldAirport.getName();

        Airport entity = new Airport(id, newCity, newName);
        airportController.update(entity, session);
    }


    private void getAllBookings(Session session) throws SQLException {
        System.out.println("\nTable: booking");
        registrationInfoController.getAll(session);
    }

    private void getBookingById(Session session) throws SQLException {
        System.out.println("Enter ID for Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.getById(id, session);
    }

    private void createBooking(Session session) throws SQLException {
        System.out.println("Enter new airline ID: ");
        Integer airlineId = INPUT.nextInt();
        System.out.println("Enter new travel class ID: ");
        Integer travelClassId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        Integer ticketId = INPUT.nextInt();
        System.out.println("Enter new plane Info ID: ");
        Integer planeInfoId = INPUT.nextInt();
        INPUT.nextLine();
        Airline airline = airlineController.getService().getById(airlineId, session);
        TravelClass travelClass = travelClassController.getService().getById(travelClassId, session);
        Ticket ticket = ticketController.getService().getById(ticketId, session);
        PlaneInfo planeInfo = planeInfoController.getService().getById(planeInfoId, session);
        Booking entity = new Booking(0, airline, travelClass, ticket, planeInfo);
        bookingController.create(entity, session);
    }

    private void deleteBookingById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.delete(id, session);
    }

    private void updateBookingById(Session session) throws SQLException {
        System.out.println("Enter booking ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Booking oldBooking = bookingController.getService().getById(id, session);
        System.out.println("Enter new airline ID: ");
        int airlineId = INPUT.nextInt();
        System.out.println("Enter new travel class ID: ");
        int travelClassId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        int ticketId = INPUT.nextInt();
        System.out.println("Enter new plane Info ID: ");
        int planeInfoId = INPUT.nextInt();
        INPUT.nextLine();


        Airline newAirline = airlineController.getService().getById(airlineId, session);
        TravelClass newTravelClass = travelClassController.getService().getById(travelClassId, session);
        Ticket newTicket = ticketController.getService().getById(ticketId, session);
        PlaneInfo newPlaneInfo = planeInfoController.getService().getById(planeInfoId, session);

        Booking entity = new Booking(id, newAirline, newTravelClass, newTicket, newPlaneInfo);
        bookingController.update(entity, session);
    }


    private void getAllClients(Session session) throws SQLException {
        System.out.println("\nTable: client");
        clientController.getAll(session);
    }

    private void getClientById(Session session) throws SQLException {
        System.out.println("Enter ID for Client: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        clientController.getById(id, session);
    }

    private void createClient(Session session) throws SQLException {
        System.out.println("Enter new info about the plane ID: ");
        Integer currentInfoAboutThePlaneId = INPUT.nextInt();
        System.out.println("Enter new booking ID: ");
        Integer bookingId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        Integer ticketId = INPUT.nextInt();
        System.out.println("Enter new client info ID: ");
        Integer infoClientId = INPUT.nextInt();
        INPUT.nextLine();
        CurrentInfoAboutThePlane currentInfoAboutThePlane =
                currentInfoAboutThePlaneController.getService().getById(currentInfoAboutThePlaneId, session);
        Booking booking = bookingController.getService().getById(bookingId, session);
        Ticket ticket = ticketController.getService().getById(ticketId, session);
        InfoClient infoClient = infoClientController.getService().getById(infoClientId, session);

        Client entity = new Client(0, currentInfoAboutThePlane, booking, ticket, infoClient);
        clientController.create(entity, session);
    }

    private void deleteClientById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Client: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        clientController.delete(id,session);
    }

    private void updateClientById(Session session) throws SQLException {
        System.out.println("Enter client ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Client oldClient = clientController.getService().getById(id, session);
        System.out.println("Enter new info about the plane ID: ");
        int currentInfoAboutThePlaneId = INPUT.nextInt();
        System.out.println("Enter new booking ID: ");
        int bookingId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        int ticketId = INPUT.nextInt();
        System.out.println("Enter new client info ID: ");
        int infoClientId = INPUT.nextInt();
        INPUT.nextLine();

        CurrentInfoAboutThePlane newCurrentInfoAboutThePlane =
                currentInfoAboutThePlaneController.getService().getById(currentInfoAboutThePlaneId, session);
        Booking newBooking = bookingController.getService().getById(bookingId, session);
        Ticket newTicket = ticketController.getService().getById(ticketId, session);
        InfoClient newInfoClient = infoClientController.getService().getById(infoClientId, session);
        Client entity = new Client(id, newCurrentInfoAboutThePlane, newBooking, newTicket, newInfoClient);
        clientController.update(entity, session);
    }



    private void getAllInfoAboutThePlanes(Session session) throws SQLException {
        System.out.println("\nTable: current_info_about_the_plane");
        currentInfoAboutThePlaneController.getAll(session);
    }

    private void getInfoAboutThePlaneById(Session session) throws SQLException {
        System.out.println("Enter ID for current info about the plane: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        currentInfoAboutThePlaneController.getById(id, session);
    }

    private void createInfoAboutThePlane(Session session) throws SQLException {
        System.out.println("Enter new airline ID: ");
        Integer airlineId = INPUT.nextInt();
        System.out.println("Enter new airport ID: ");
        Integer airportId = INPUT.nextInt();
        System.out.println("Enter new registration info ID: ");
        Integer registrationInfoId = INPUT.nextInt();
        System.out.println("Enter new flight ID: ");
        Integer flightId = INPUT.nextInt();
        System.out.println("Enter new route ID: ");
        Integer routeId = INPUT.nextInt();
        System.out.println("Enter new schedule ID: ");
        Integer scheduleId = INPUT.nextInt();
        System.out.println("Enter new plane info ID: ");
        Integer planeInfoId = INPUT.nextInt();
        INPUT.nextLine();
        Airline airline = airlineController.getService().getById(airlineId, session);
        Airport airport = airportController.getService().getById(airportId, session);
        RegistrationInfo registrationInfo = registrationInfoController.getService().getById(registrationInfoId, session);
        Flight flight = flightController.getService().getById(flightId, session);
        Route route = routeController.getService().getById(routeId, session);
        PlaneInfo planeInfo = planeInfoController.getService().getById(planeInfoId, session);
        CurrentInfoAboutThePlane entity = new CurrentInfoAboutThePlane(0, airline, airport, registrationInfo,
                flight, route, planeInfo);
        currentInfoAboutThePlaneController.create(entity, session);
    }

    private void deleteInfoAboutThePlaneById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Current Info About The Plane: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        currentInfoAboutThePlaneController.delete(id, session);
    }

    private void updateInfoAboutThePlaneById(Session session) throws SQLException {
        System.out.println("Enter current info about the plane ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        CurrentInfoAboutThePlane oldInfoAboutThePlane = currentInfoAboutThePlaneController.getService().getById(id, session);
        System.out.println("Enter new airline ID: ");
        int airlineId = INPUT.nextInt();
        System.out.println("Enter new airport ID: ");
        int airportId = INPUT.nextInt();
        System.out.println("Enter new registration info ID: ");
        int registrationInfoId = INPUT.nextInt();
        System.out.println("Enter new flight ID: ");
        int flightId = INPUT.nextInt();
        System.out.println("Enter new route ID: ");
        int routeId = INPUT.nextInt();
        System.out.println("Enter new schedule ID: ");
        int scheduleId = INPUT.nextInt();
        System.out.println("Enter new plane info ID: ");
        int planeInfoId = INPUT.nextInt();
        INPUT.nextLine();

        Airline newAirline = airlineController.getService().getById(airlineId, session);
        Airport newAirport = airportController.getService().getById(airportId, session);
        RegistrationInfo newRegistrationInfo = registrationInfoController.getService().getById(registrationInfoId, session);
        Flight newFlight = flightController.getService().getById(flightId, session);
        Route newRoute = routeController.getService().getById(routeId, session);
        PlaneInfo newPlaneInfo = planeInfoController.getService().getById(planeInfoId, session);

        CurrentInfoAboutThePlane entity = new CurrentInfoAboutThePlane(id, newAirline, newAirport,
                newRegistrationInfo, newFlight, newRoute, newPlaneInfo);
        currentInfoAboutThePlaneController.update(entity, session);
    }




    private void getAllFlights(Session session) throws SQLException {
        System.out.println("\nTable: flight");
        flightController.getAll(session);
    }

    private void getFlightById(Session session) throws SQLException {
        System.out.println("Enter ID for Flight: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        flightController.getById(id, session);
    }

    private void createFlight(Session session) throws SQLException {
        System.out.println("Enter new departure point: ");
        String departurePoint = INPUT.nextLine();
        System.out.println("Enter new destination: ");
        String destination = INPUT.nextLine();
        INPUT.nextLine();
        Flight entity = new Flight(0, departurePoint, destination);
        flightController.create(entity,session);
    }

    private void deleteFlightById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Flight: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        flightController.delete(id, session);
    }

    private void updateFlightById(Session session) throws SQLException {
        System.out.println("Enter flight id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Flight oldFlight = flightController.getService().getById(id,session);
        System.out.println("Enter new departure point: ");
        String departurePoint = INPUT.nextLine();
        System.out.println("Enter new destination: ");
        String destination = INPUT.nextLine();
        INPUT.nextLine();

        String newDeparturePoint = departurePoint;
        String newDestination = destination;

        if (departurePoint.equals("")) newDeparturePoint = oldFlight.getDeparturePoint();
        if (destination.equals("")) newDestination = oldFlight.getDestination();

        Flight entity = new Flight(id, newDeparturePoint, newDestination);
        flightController.update(entity, session);
    }



    private void getAllInfoClients(Session session) throws SQLException {
        System.out.println("\nTable: client_info");
        infoClientController.getAll(session);
    }

    private void getInfoClientById(Session session) throws SQLException {
        System.out.println("Enter ID for Client Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        infoClientController.getById(id,session);
    }

    private void createInfoClient(Session session) throws SQLException {
        System.out.println("Enter new first name: ");
        String firstName = INPUT.nextLine();
        System.out.println("Enter new middle name: ");
        String middleName = INPUT.nextLine();
        System.out.println("Enter new last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new phone number: ");
        String phone = INPUT.nextLine();
        System.out.println("Enter new email: ");
        String email = INPUT.nextLine();
        System.out.println("Enter new passport: ");
        String passport = INPUT.nextLine();
        INPUT.nextLine();
        InfoClient entity = new InfoClient(0, firstName, middleName, lastName, phone , email, passport);
        infoClientController.create(entity, session);
    }

    private void deleteInfoClientById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Client Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        infoClientController.delete(id, session);
    }

    private void updateInfoClientById(Session session) throws SQLException {
        System.out.println("Enter Client Info ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        InfoClient oldInfoClient = infoClientController.getService().getById(id, session);
        System.out.println("Enter new first name: ");
        String firstName = INPUT.nextLine();
        System.out.println("Enter new middle name: ");
        String middleName = INPUT.nextLine();
        System.out.println("Enter new last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter new phone number: ");
        String phone = INPUT.nextLine();
        System.out.println("Enter new email: ");
        String email = INPUT.nextLine();
        System.out.println("Enter new passport: ");
        String passport = INPUT.nextLine();
        INPUT.nextLine();

        String newFirstName = firstName;
        String newMiddleName = middleName;
        String newLastName = lastName;
        String newPhone = phone;
        String newEmail = email;
        String newPassport = passport;


        if (firstName.equals("")) newFirstName = oldInfoClient.getFirstName();
        if (middleName.equals("")) newMiddleName = oldInfoClient.getMiddleName();
        if (lastName.equals("")) newLastName = oldInfoClient.getLastName();
        if (phone.equals("")) newPhone = oldInfoClient.getPhone();
        if (email.equals("")) newEmail = oldInfoClient.getEmail();
        if (passport.equals("")) newPassport = oldInfoClient.getPassport();

        InfoClient entity = new InfoClient(id, newFirstName, newMiddleName, newLastName,
                newPhone, newEmail, newPassport);
        infoClientController.update(entity, session);
    }



    private void getAllPaymentBookings(Session session) throws SQLException {
        System.out.println("\nTable: payment_booking");
        paymentBookingController.getAll(session);
    }

    private void getPaymentBookingById(Session session) throws SQLException {
        System.out.println("Enter ID for Payment Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        paymentBookingController.getById(id, session);
    }

    private void createPaymentBooking(Session session) throws SQLException {
        System.out.println("Enter new status: ");
        String status = INPUT.nextLine();
        INPUT.nextLine();
        PaymentBooking entity = new PaymentBooking(0, status);
        paymentBookingController.create(entity, session);
    }

    private void deletePaymentBookingById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Payment Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        paymentBookingController.delete(id, session);
    }

    private void updatePaymentBookingById(Session session) throws SQLException {
        System.out.println("Enter Payment Booking id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PaymentBooking oldPaymentBooking = paymentBookingController.getService().getById(id, session);
        System.out.println("Enter new status for payment booking: ");
        String status = INPUT.nextLine();
        INPUT.nextLine();

        String newStatus = status;

        if (status.equals("")) newStatus = oldPaymentBooking.getStatus();

        PaymentBooking entity = new PaymentBooking(id, newStatus);
        paymentBookingController.update(entity, session);
    }



    private void getAllPlaneInfos(Session session) throws SQLException {
        System.out.println("\nTable: plane_info");
        planeInfoController.getAll(session);
    }

    private void getPlaneInfoById(Session session) throws SQLException {
        System.out.println("Enter ID for Plane Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        planeInfoController.getById(id, session);
    }

    private void createPlaneInfo(Session session) throws SQLException {
        System.out.println("Enter new number seats: ");
        Integer number_seats = INPUT.nextInt();
        System.out.println("Enter new status: ");
        String status = INPUT.nextLine();
        INPUT.nextLine();
        PlaneInfo entity = new PlaneInfo(0, number_seats, status);
        planeInfoController.create(entity, session);
    }

    private void deletePlaneInfoById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Plane Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        planeInfoController.delete(id, session);
    }

    private void updatePlaneInfoById(Session session) throws SQLException {
        System.out.println("Enter Plane Info id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PlaneInfo oldPlaneInfo = planeInfoController.getService().getById(id,session);
        System.out.println("Enter new number seats: ");
        int number_seats = INPUT.nextInt();
        System.out.println("Enter new status for payment booking: ");
        String status = INPUT.nextLine();
        INPUT.nextLine();

        Integer newNumberSeats = number_seats;
        String newStatus = status;

        if (number_seats < 0) newNumberSeats = oldPlaneInfo.getNumberSeats();
        if (status.equals("")) newStatus = oldPlaneInfo.getStatus();

        PlaneInfo entity = new PlaneInfo(id, newNumberSeats,newStatus);
        planeInfoController.update(entity, session);
    }



    private void getAllRegistrationInfos(Session session) throws SQLException {
        System.out.println("\nTable: registration_info");
        registrationInfoController.getAll(session);
    }

    private void getRegistrationInfoById(Session session) throws SQLException {
        System.out.println("Enter ID for Registration Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.getById(id, session);
    }

    private void createRegistrationInfo(Session session) throws SQLException {
        System.out.println("Enter new manufacture year: ");
        Integer manufactureYear = INPUT.nextInt();
        System.out.println("Enter new general plaque in hours: ");
        Integer generalPlaqueHours = INPUT.nextInt();
        System.out.println("Enter new model: ");
        String model = INPUT.nextLine();
        System.out.println("Enter new board number: ");
        String boardNumber = INPUT.nextLine();
        INPUT.nextLine();
        RegistrationInfo entity = new RegistrationInfo(0, manufactureYear, generalPlaqueHours, model, boardNumber);
        registrationInfoController.create(entity, session);
    }

    private void deleteRegistrationInfoById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Registration Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.delete(id, session);
    }

    private void updateRegistrationInfoById(Session session) throws SQLException {
        System.out.println("Enter Registration Info ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        RegistrationInfo oldRegistrationInfo = registrationInfoController.getService().getById(id,session);
        System.out.println("Enter new manufacture year: ");
        int manufactureYear = INPUT.nextInt();
        System.out.println("Enter new general plaque in hours: ");
        int generalPlaqueHours = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        String model = INPUT.nextLine();
        System.out.println("Enter new plane Info ID: ");
        String boardNumber = INPUT.nextLine();
        INPUT.nextLine();

        Integer newManufactureYear = manufactureYear;
        Integer newGeneralPlaqueHours = generalPlaqueHours;
        String newModel = model;
        String newBoardNumber = boardNumber;

        if (manufactureYear < 0) newManufactureYear = oldRegistrationInfo.getManufactureYear();
        if (generalPlaqueHours < 0) newGeneralPlaqueHours = oldRegistrationInfo.getGeneralPlaqueHours();
        if (model.equals("")) newModel = oldRegistrationInfo.getModel();
        if (boardNumber.equals("")) newBoardNumber = oldRegistrationInfo.getBoardNumber();

        RegistrationInfo entity = new RegistrationInfo(id, newManufactureYear, newGeneralPlaqueHours, newModel, newBoardNumber);
        registrationInfoController.update(entity, session);
    }



    private void getAllRoutes(Session session) throws SQLException {
        System.out.println("\nTable: route");
        routeController.getAll(session);
    }

    private void getRouteById(Session session) throws SQLException {
        System.out.println("Enter ID for Route: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        routeController.getById(id, session);
    }

    private void createRoute(Session session) throws SQLException {
        System.out.println("Enter new speed: ");
        Integer speedKmPerHours = INPUT.nextInt();
        System.out.println("Enter new destination: ");
        Integer destinationInKm = INPUT.nextInt();
        INPUT.nextLine();
        Route entity = new Route(0, speedKmPerHours, destinationInKm);
        routeController.create(entity, session);
    }

    private void deleteRouteById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Route: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        routeController.delete(id, session);
    }

    private void updateRouteById(Session session) throws SQLException {
        System.out.println("Enter Route ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Route oldRoute = routeController.getService().getById(id, session);
        System.out.println("Enter new speed: ");
        int speedKmPerHours = INPUT.nextInt();
        System.out.println("Enter new destination: ");
        int destinationInKm = INPUT.nextInt();
        INPUT.nextLine();

        Integer newSpeedKmPerHours = speedKmPerHours;
        Integer newDestinationInKm = destinationInKm;

        if (speedKmPerHours < 0) newSpeedKmPerHours = oldRoute.getSpeedKmPerHours();
        if (destinationInKm < 0) newDestinationInKm = oldRoute.getDestinationInKm();

        Route entity = new Route(id, newSpeedKmPerHours, newDestinationInKm);
        routeController.update(entity, session);
    }



    private void getAllSchedules(Session session) throws SQLException {
        System.out.println("\nTable: schedule");
        scheduleController.getAll(session);
    }

    private void getScheduleById(Session session) throws SQLException {
        System.out.println("Enter ID for Schedule: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        scheduleController.getById(id, session);
    }

    private void createSchedule(Session session) throws SQLException {
        System.out.println("Enter new arrival time: ");
        String arrivalTime = INPUT.nextLine();
        System.out.println("Enter new departure time: ");
        String departureTime = INPUT.nextLine();
        INPUT.nextLine();
        Schedule entity = new Schedule(0, arrivalTime, departureTime);
        scheduleController.create(entity, session);
    }

    private void deleteScheduleById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Schedule: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        scheduleController.delete(id, session);
    }

    private void updateScheduleById(Session session) throws SQLException {
        System.out.println("Enter Schedule id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Schedule oldSchedule = scheduleController.getService().getById(id, session);
        System.out.println("Enter new arrival time: ");
        String arrivalTime = INPUT.nextLine();
        System.out.println("Enter new departure time: ");
        String departureTime = INPUT.nextLine();
        INPUT.nextLine();

        String newArrivalTime = arrivalTime;
        String newDepartureTime = departureTime;

        if (arrivalTime.equals("")) newArrivalTime = oldSchedule.getArrivalTime();
        if (departureTime.equals("")) newDepartureTime = oldSchedule.getDepartureTime();

        Schedule entity = new Schedule(id, newArrivalTime, newDepartureTime);
        scheduleController.update(entity, session);
    }




    private void getAllTickets(Session session) throws SQLException {
        System.out.println("\nTable: ticket");
        ticketController.getAll(session);
    }

    private void getTicketById(Session session) throws SQLException {
        System.out.println("Enter ID for Ticket: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ticketController.getById(id, session);
    }

    private void createTicket(Session session) throws SQLException {
        System.out.println("Enter new price: ");
        Integer price = INPUT.nextInt();
        System.out.println("Enter new payment booking ID: ");
        Integer paymentBookingId = INPUT.nextInt();
        INPUT.nextLine();
        PaymentBooking paymentBooking = paymentBookingController.getService().getById(paymentBookingId, session);
        Ticket entity = new Ticket(0, price, paymentBooking);
        ticketController.create(entity,session);
    }

    private void deleteTicketById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Ticket: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ticketController.delete(id, session);
    }

    private void updateTicketById(Session session) throws SQLException {
        System.out.println("Enter Ticket ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Ticket oldTicket = ticketController.getService().getById(id, session);
        System.out.println("Enter new price: ");
        int price = INPUT.nextInt();
        System.out.println("Enter new payment booking ID: ");
        int paymentBookingId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newPrice = price;


        if (price < 0) newPrice = oldTicket.getPrice();
        PaymentBooking newPaymentBooking = paymentBookingController.getService().getById(paymentBookingId, session);

        Ticket entity = new Ticket(id, newPrice, newPaymentBooking);
        ticketController.update(entity, session);
    }




    private void getAllTravelClasses(Session session) throws SQLException {
        System.out.println("\nTable: travel_class");
        travelClassController.getAll(session);
    }

    private void getTravelClassById(Session session) throws SQLException {
        System.out.println("Enter ID for Travel Class: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        travelClassController.getById(id, session);
    }

    private void createTravelClass(Session session) throws SQLException {
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();
        INPUT.nextLine();
        TravelClass entity = new TravelClass(0, name);
        travelClassController.create(entity, session);
    }

    private void deleteTravelClassById(Session session) throws SQLException {
        System.out.println("Enter ID to delete Travel Class: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        travelClassController.delete(id, session);
    }

    private void updateTravelClassById(Session session) throws SQLException {
        System.out.println("Enter Travel Class id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        TravelClass oldTravelClass = travelClassController.getService().getById(id,session);
        System.out.println("Enter new name for travel class: ");
        String name = INPUT.nextLine();
        INPUT.nextLine();

        String newName = name;

        if (name.equals("")) newName = oldTravelClass.getName();

        TravelClass entity = new TravelClass(id, newName);
        travelClassController.update(entity,session);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) { }
        } while (!keyMenu.equals("Q"));
    }
}