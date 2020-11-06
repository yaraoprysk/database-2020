package view;

import controller.implementation.*;
import model.implementation.*;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
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
    private static final Scanner INPUT = new Scanner(System.in);

    public MainView() {
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


        methodsMenu.put("11", this::getAllAirlines);
        methodsMenu.put("12", this::getAirlineById);
        methodsMenu.put("13", this::createAirline);
        methodsMenu.put("14", this::deleteAirlineById);
        methodsMenu.put("15", this::updateAirlineById);

        methodsMenu.put("21", this::getAllAirports);
        methodsMenu.put("22", this::getAirportById);
        methodsMenu.put("23", this::createAirport);
        methodsMenu.put("24", this::deleteAirportById);
        methodsMenu.put("25", this::updateAirportById);

        methodsMenu.put("31", this::getAllBookings);
        methodsMenu.put("32", this::getBookingById);
        methodsMenu.put("33", this::createBooking);
        methodsMenu.put("34", this::deleteBookingById);
        methodsMenu.put("35", this::updateBookingById);

        methodsMenu.put("41", this::getAllClients);
        methodsMenu.put("42", this::getClientById);
        methodsMenu.put("43", this::createClient);
        methodsMenu.put("44", this::deleteClientById);
        methodsMenu.put("45", this::updateClientById);

        methodsMenu.put("51", this::getAllInfoAboutThePlanes);
        methodsMenu.put("52", this::getInfoAboutThePlaneById);
        methodsMenu.put("53", this::createInfoAboutThePlane);
        methodsMenu.put("54", this::deleteInfoAboutThePlaneById);
        methodsMenu.put("55", this::updateInfoAboutThePlaneById);

        methodsMenu.put("61", this::getAllFlights);
        methodsMenu.put("62", this::getFlightById);
        methodsMenu.put("63", this::createFlight);
        methodsMenu.put("64", this::deleteFlightById);
        methodsMenu.put("65", this::updateFlightById);

        methodsMenu.put("71", this::getAllInfoClients);
        methodsMenu.put("72", this::getInfoClientById);
        methodsMenu.put("73", this::createInfoClient);
        methodsMenu.put("74", this::deleteInfoClientById);
        methodsMenu.put("75", this::updateInfoClientById);

        methodsMenu.put("81", this::getAllPaymentBookings);
        methodsMenu.put("82", this::getPaymentBookingById);
        methodsMenu.put("83", this::createPaymentBooking);
        methodsMenu.put("84", this::deletePaymentBookingById);
        methodsMenu.put("85", this::updatePaymentBookingById);

        methodsMenu.put("91", this::getAllPlaneInfos);
        methodsMenu.put("92", this::getPlaneInfoById);
        methodsMenu.put("93", this::createPlaneInfo);
        methodsMenu.put("94", this::deletePlaneInfoById);
        methodsMenu.put("95", this::updatePlaneInfoById);

        methodsMenu.put("101", this::getAllRegistrationInfos);
        methodsMenu.put("102", this::getRegistrationInfoById);
        methodsMenu.put("103", this::createRegistrationInfo);
        methodsMenu.put("104", this::deleteRegistrationInfoById);
        methodsMenu.put("105", this::updateRegistrationInfoById);

        methodsMenu.put("111", this::getAllRoutes);
        methodsMenu.put("112", this::getRouteById);
        methodsMenu.put("113", this::createRoute);
        methodsMenu.put("114", this::deleteRouteById);
        methodsMenu.put("115", this::updateRouteById);

        methodsMenu.put("121", this::getAllSchedules);
        methodsMenu.put("122", this::getScheduleById);
        methodsMenu.put("123", this::createSchedule);
        methodsMenu.put("124", this::deleteScheduleById);
        methodsMenu.put("125", this::updateScheduleById);

        methodsMenu.put("131", this::getAllTickets);
        methodsMenu.put("132", this::getTicketById);
        methodsMenu.put("133", this::createTicket);
        methodsMenu.put("134", this::deleteTicketById);
        methodsMenu.put("135", this::updateTicketById);

        methodsMenu.put("141", this::getAllTravelClasses);
        methodsMenu.put("142", this::getTravelClassById);
        methodsMenu.put("143", this::createTravelClass);
        methodsMenu.put("144", this::deleteTravelClassById);
        methodsMenu.put("145", this::updateTravelClassById);
    }


    private void getAllAirlines() throws SQLException {
        System.out.println("\nTable: airline");
        airlineController.getAll();
    }

    private void getAirlineById() throws SQLException {
        System.out.println("Enter ID for Airline: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airlineController.getById(id);
    }

    private void createAirline() throws SQLException {
        System.out.println("Enter new airline name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new airline country: ");
        String country = INPUT.nextLine();
        INPUT.nextLine();
        Airline entity = new Airline(0, name, country);
        airlineController.create(entity);
    }

    private void deleteAirlineById() throws SQLException {
        System.out.println("Enter ID to delete Airline: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airlineController.delete(id);
    }

    private void updateAirlineById() throws SQLException {
        System.out.println("Enter airline id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Airline oldAirline = airlineController.getService().getById(id);
        System.out.println("Enter new name for airline: ");
        String name = INPUT.nextLine();
        System.out.println("Enter new country for airline: ");
        String country = INPUT.nextLine();
        INPUT.nextLine();

        String newName = name;
        String newCountry = country;

        if (name.equals("")) newName = oldAirline.getName();
        if (country.equals("")) newCountry = oldAirline.getCountry();

        Airline entity = new Airline(id, newName, newCountry);
        airlineController.update(entity);
    }


    private void getAllAirports() throws SQLException {
        System.out.println("\nTable: airport");
        airportController.getAll();
    }

    private void getAirportById() throws SQLException {
        System.out.println("Enter ID for Airport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airportController.getById(id);
    }

    private void createAirport() throws SQLException {
        System.out.println("Enter new airport city: ");
        String city = INPUT.nextLine();
        System.out.println("Enter new airport name: ");
        String name = INPUT.nextLine();
        INPUT.nextLine();
        Airport entity = new Airport(0, city, name);
        airportController.create(entity);
    }

    private void deleteAirportById() throws SQLException {
        System.out.println("Enter ID to delete Airport: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        airportController.delete(id);
    }

    private void updateAirportById() throws SQLException {
        System.out.println("Enter airport id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Airport oldAirport = airportController.getService().getById(id);
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
        airportController.update(entity);
    }


    private void getAllBookings() throws SQLException {
        System.out.println("\nTable: booking");
        registrationInfoController.getAll();
    }

    private void getBookingById() throws SQLException {
        System.out.println("Enter ID for Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.getById(id);
    }

    private void createBooking() throws SQLException {
        System.out.println("Enter new airline ID: ");
        Integer airlineId = INPUT.nextInt();
        System.out.println("Enter new travel class ID: ");
        Integer travelClassId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        Integer ticketId = INPUT.nextInt();
        System.out.println("Enter new plane Info ID: ");
        Integer planeInfoId = INPUT.nextInt();
        INPUT.nextLine();
        Booking entity = new Booking(0, airlineId, travelClassId, ticketId, planeInfoId);
        bookingController.create(entity);
    }

    private void deleteBookingById() throws SQLException {
        System.out.println("Enter ID to delete Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.delete(id);
    }

    private void updateBookingById() throws SQLException {
        System.out.println("Enter booking ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Booking oldBooking = bookingController.getService().getById(id);
        System.out.println("Enter new airline ID: ");
        int airlineId = INPUT.nextInt();
        System.out.println("Enter new travel class ID: ");
        int travelClassId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        int ticketId = INPUT.nextInt();
        System.out.println("Enter new plane Info ID: ");
        int planeInfoId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newAirlineId = airlineId;
        Integer newTravelClassId = travelClassId;
        Integer newTicketId = ticketId;
        Integer newPlaneInfoId = planeInfoId;

        if (airlineId < 0) newAirlineId = oldBooking.getAirlineId();
        if (travelClassId < 0) newTravelClassId = oldBooking.getTravelClassId();
        if (ticketId < 0) newTicketId = oldBooking.getTicketId();
        if (planeInfoId < 0) newPlaneInfoId = oldBooking.getPlaneInfoId();

        Booking entity = new Booking(id, newAirlineId, newTravelClassId, newTicketId, newPlaneInfoId);
        bookingController.update(entity);
    }


    private void getAllClients() throws SQLException {
        System.out.println("\nTable: client");
        clientController.getAll();
    }

    private void getClientById() throws SQLException {
        System.out.println("Enter ID for Client: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        clientController.getById(id);
    }

    private void createClient() throws SQLException {
        System.out.println("Enter new info about the plane ID: ");
        Integer currentInfoAboutThePlaneId = INPUT.nextInt();
        System.out.println("Enter new booking ID: ");
        Integer bookingId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        Integer ticketId = INPUT.nextInt();
        System.out.println("Enter new client info ID: ");
        Integer infoClientId = INPUT.nextInt();
        INPUT.nextLine();
        Client entity = new Client(0, currentInfoAboutThePlaneId, bookingId, ticketId, infoClientId);
        clientController.create(entity);
    }

    private void deleteClientById() throws SQLException {
        System.out.println("Enter ID to delete Client: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        clientController.delete(id);
    }

    private void updateClientById() throws SQLException {
        System.out.println("Enter client ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Client oldClient = clientController.getService().getById(id);
        System.out.println("Enter new info about the plane ID: ");
        int currentInfoAboutThePlaneId = INPUT.nextInt();
        System.out.println("Enter new booking ID: ");
        int bookingId = INPUT.nextInt();
        System.out.println("Enter new ticket ID: ");
        int ticketId = INPUT.nextInt();
        System.out.println("Enter new client info ID: ");
        int infoClientId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newCurrentInfoAboutThePlaneId = currentInfoAboutThePlaneId;
        Integer newBookingId = bookingId;
        Integer newTicketId = ticketId;
        Integer newInfoClientId = infoClientId;

        if (currentInfoAboutThePlaneId < 0) newCurrentInfoAboutThePlaneId = oldClient.getCurrentInfoAboutThePlaneId();
        if (bookingId < 0) newBookingId = oldClient.getBookingId();
        if (ticketId < 0) newTicketId = oldClient.getTicketId();
        if (infoClientId < 0) newInfoClientId = oldClient.getInfoClientId();

        Client entity = new Client(id, newCurrentInfoAboutThePlaneId, newBookingId, newTicketId, newInfoClientId);
        clientController.update(entity);
    }



    private void getAllInfoAboutThePlanes() throws SQLException {
        System.out.println("\nTable: current_info_about_the_plane");
        currentInfoAboutThePlaneController.getAll();
    }

    private void getInfoAboutThePlaneById() throws SQLException {
        System.out.println("Enter ID for current info about the plane: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        currentInfoAboutThePlaneController.getById(id);
    }

    private void createInfoAboutThePlane() throws SQLException {
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
        CurrentInfoAboutThePlane entity = new CurrentInfoAboutThePlane(0, airlineId, airportId, registrationInfoId, flightId, routeId, scheduleId, planeInfoId);
        currentInfoAboutThePlaneController.create(entity);
    }

    private void deleteInfoAboutThePlaneById() throws SQLException {
        System.out.println("Enter ID to delete Current Info About The Plane: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        currentInfoAboutThePlaneController.delete(id);
    }

    private void updateInfoAboutThePlaneById() throws SQLException {
        System.out.println("Enter current info about the plane ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        CurrentInfoAboutThePlane oldInfoAboutThePlane = currentInfoAboutThePlaneController.getService().getById(id);
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

        Integer newAirlineId = airlineId;
        Integer newAirportId = airportId;
        Integer newRegistrationInfoId = registrationInfoId;
        Integer newFlightId = flightId;
        Integer newRouteId = routeId;
        Integer newScheduleId = scheduleId;
        Integer newPlaneInfoId = planeInfoId;

        if (airlineId < 0) newAirlineId = oldInfoAboutThePlane.getAirlineId();
        if (airportId < 0) newAirportId = oldInfoAboutThePlane.getAirportId();
        if (registrationInfoId < 0) newRegistrationInfoId = oldInfoAboutThePlane.getRegistrationInfoId();
        if (flightId < 0) newFlightId = oldInfoAboutThePlane.getFlightId();
        if (routeId < 0) newRouteId = oldInfoAboutThePlane.getRouteId();
        if (scheduleId < 0) newScheduleId = oldInfoAboutThePlane.getScheduleId();
        if (planeInfoId < 0) newPlaneInfoId = oldInfoAboutThePlane.getPlaneInfoId();

        CurrentInfoAboutThePlane entity = new CurrentInfoAboutThePlane(id, newAirlineId, newAirportId,
                newRegistrationInfoId, newFlightId, newRouteId, newScheduleId, newPlaneInfoId);
        currentInfoAboutThePlaneController.update(entity);
    }




    private void getAllFlights() throws SQLException {
        System.out.println("\nTable: flight");
        flightController.getAll();
    }

    private void getFlightById() throws SQLException {
        System.out.println("Enter ID for Flight: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        flightController.getById(id);
    }

    private void createFlight() throws SQLException {
        System.out.println("Enter new departure point: ");
        String departurePoint = INPUT.nextLine();
        System.out.println("Enter new destination: ");
        String destination = INPUT.nextLine();
        INPUT.nextLine();
        Flight entity = new Flight(0, departurePoint, destination);
        flightController.create(entity);
    }

    private void deleteFlightById() throws SQLException {
        System.out.println("Enter ID to delete Flight: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        flightController.delete(id);
    }

    private void updateFlightById() throws SQLException {
        System.out.println("Enter flight id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
       Flight oldFlight = flightController.getService().getById(id);
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
        flightController.update(entity);
    }



    private void getAllInfoClients() throws SQLException {
        System.out.println("\nTable: client_info");
        infoClientController.getAll();
    }

    private void getInfoClientById() throws SQLException {
        System.out.println("Enter ID for Client Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        infoClientController.getById(id);
    }

    private void createInfoClient() throws SQLException {
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
        infoClientController.create(entity);
    }

    private void deleteInfoClientById() throws SQLException {
        System.out.println("Enter ID to delete Client Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        infoClientController.delete(id);
    }

    private void updateInfoClientById() throws SQLException {
        System.out.println("Enter Client Info ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        InfoClient oldInfoClient = infoClientController.getService().getById(id);
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
        infoClientController.update(entity);
    }



    private void getAllPaymentBookings() throws SQLException {
        System.out.println("\nTable: payment_booking");
        paymentBookingController.getAll();
    }

    private void getPaymentBookingById() throws SQLException {
        System.out.println("Enter ID for Payment Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        paymentBookingController.getById(id);
    }

    private void createPaymentBooking() throws SQLException {
        System.out.println("Enter new status: ");
        String status = INPUT.nextLine();
        INPUT.nextLine();
        PaymentBooking entity = new PaymentBooking(0, status);
        paymentBookingController.create(entity);
    }

    private void deletePaymentBookingById() throws SQLException {
        System.out.println("Enter ID to delete Payment Booking: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        paymentBookingController.delete(id);
    }

    private void updatePaymentBookingById() throws SQLException {
        System.out.println("Enter Payment Booking id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PaymentBooking oldPaymentBooking = paymentBookingController.getService().getById(id);
        System.out.println("Enter new status for payment booking: ");
        String status = INPUT.nextLine();
        INPUT.nextLine();

        String newStatus = status;

        if (status.equals("")) newStatus = oldPaymentBooking.getStatus();

        PaymentBooking entity = new PaymentBooking(id, newStatus);
        paymentBookingController.update(entity);
    }



    private void getAllPlaneInfos() throws SQLException {
        System.out.println("\nTable: plane_info");
        planeInfoController.getAll();
    }

    private void getPlaneInfoById() throws SQLException {
        System.out.println("Enter ID for Plane Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        planeInfoController.getById(id);
    }

    private void createPlaneInfo() throws SQLException {
        System.out.println("Enter new number seats: ");
        Integer number_seats = INPUT.nextInt();
        System.out.println("Enter new status: ");
        String status = INPUT.nextLine();
        INPUT.nextLine();
        PlaneInfo entity = new PlaneInfo(0, number_seats, status);
        planeInfoController.create(entity);
    }

    private void deletePlaneInfoById() throws SQLException {
        System.out.println("Enter ID to delete Plane Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        planeInfoController.delete(id);
    }

    private void updatePlaneInfoById() throws SQLException {
        System.out.println("Enter Plane Info id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        PlaneInfo oldPlaneInfo = planeInfoController.getService().getById(id);
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
        planeInfoController.update(entity);
    }



    private void getAllRegistrationInfos() throws SQLException {
        System.out.println("\nTable: booking");
        registrationInfoController.getAll();
    }

    private void getRegistrationInfoById() throws SQLException {
        System.out.println("Enter ID for Registration Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.getById(id);
    }

    private void createRegistrationInfo() throws SQLException {
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
        registrationInfoController.create(entity);
    }

    private void deleteRegistrationInfoById() throws SQLException {
        System.out.println("Enter ID to delete Registration Info: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        registrationInfoController.delete(id);
    }

    private void updateRegistrationInfoById() throws SQLException {
        System.out.println("Enter Registration Info ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        RegistrationInfo oldRegistrationInfo = registrationInfoController.getService().getById(id);
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
        registrationInfoController.update(entity);
    }



    private void getAllRoutes() throws SQLException {
        System.out.println("\nTable: route");
        routeController.getAll();
    }

    private void getRouteById() throws SQLException {
        System.out.println("Enter ID for Route: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        routeController.getById(id);
    }

    private void createRoute() throws SQLException {
        System.out.println("Enter new speed: ");
        Integer speedKmPerHours = INPUT.nextInt();
        System.out.println("Enter new destination: ");
        Integer destinationInKm = INPUT.nextInt();
        INPUT.nextLine();
        Route entity = new Route(0, speedKmPerHours, destinationInKm);
        routeController.create(entity);
    }

    private void deleteRouteById() throws SQLException {
        System.out.println("Enter ID to delete Route: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        routeController.delete(id);
    }

    private void updateRouteById() throws SQLException {
        System.out.println("Enter Route ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Route oldRoute = routeController.getService().getById(id);
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
        routeController.update(entity);
    }



    private void getAllSchedules() throws SQLException {
        System.out.println("\nTable: schedule");
        scheduleController.getAll();
    }

    private void getScheduleById() throws SQLException {
        System.out.println("Enter ID for Schedule: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        scheduleController.getById(id);
    }

    private void createSchedule() throws SQLException {
        System.out.println("Enter new arrival time: ");
        String arrivalTime = INPUT.nextLine();
        System.out.println("Enter new departure time: ");
        String departureTime = INPUT.nextLine();
        INPUT.nextLine();
        Schedule entity = new Schedule(0, arrivalTime, departureTime);
        scheduleController.create(entity);
    }

    private void deleteScheduleById() throws SQLException {
        System.out.println("Enter ID to delete Schedule: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        scheduleController.delete(id);
    }

    private void updateScheduleById() throws SQLException {
        System.out.println("Enter Schedule id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Schedule oldSchedule = scheduleController.getService().getById(id);
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
        scheduleController.update(entity);
    }




    private void getAllTickets() throws SQLException {
        System.out.println("\nTable: ticket");
        ticketController.getAll();
    }

    private void getTicketById() throws SQLException {
        System.out.println("Enter ID for Ticket: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ticketController.getById(id);
    }

    private void createTicket() throws SQLException {
        System.out.println("Enter new price: ");
        Integer price = INPUT.nextInt();
        System.out.println("Enter new payment booking ID: ");
        Integer paymentBookingId = INPUT.nextInt();
        INPUT.nextLine();
        Ticket entity = new Ticket(0, price, paymentBookingId);
        ticketController.create(entity);
    }

    private void deleteTicketById() throws SQLException {
        System.out.println("Enter ID to delete Ticket: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        ticketController.delete(id);
    }

    private void updateTicketById() throws SQLException {
        System.out.println("Enter Ticket ID to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Ticket oldTicket = ticketController.getService().getById(id);
        System.out.println("Enter new price: ");
        int price = INPUT.nextInt();
        System.out.println("Enter new payment booking ID: ");
        int paymentBookingId = INPUT.nextInt();
        INPUT.nextLine();

        Integer newPrice = price;
        Integer newPaymentBookingId = paymentBookingId;

        if (price < 0) newPrice = oldTicket.getPrice();
        if (paymentBookingId < 0) newPaymentBookingId = oldTicket.getPaymentBookingId();

        Ticket entity = new Ticket(id, newPrice, newPaymentBookingId);
        ticketController.update(entity);
    }




    private void getAllTravelClasses() throws SQLException {
        System.out.println("\nTable: travel_class");
        travelClassController.getAll();
    }

    private void getTravelClassById() throws SQLException {
        System.out.println("Enter ID for Travel Class: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        travelClassController.getById(id);
    }

    private void createTravelClass() throws SQLException {
        System.out.println("Enter new name: ");
        String name = INPUT.nextLine();
        INPUT.nextLine();
        TravelClass entity = new TravelClass(0, name);
        travelClassController.create(entity);
    }

    private void deleteTravelClassById() throws SQLException {
        System.out.println("Enter ID to delete Travel Class: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        travelClassController.delete(id);
    }

    private void updateTravelClassById() throws SQLException {
        System.out.println("Enter Travel Class id to update: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        TravelClass oldTravelClass = travelClassController.getService().getById(id);
        System.out.println("Enter new name for travel class: ");
        String name = INPUT.nextLine();
        INPUT.nextLine();

        String newName = name;

        if (name.equals("")) newName = oldTravelClass.getName();

        TravelClass entity = new TravelClass(id, newName);
        travelClassController.update(entity);
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