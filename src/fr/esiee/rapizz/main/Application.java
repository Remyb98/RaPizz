package fr.esiee.rapizz.main;

import fr.esiee.rapizz.dao.*;
import fr.esiee.rapizz.model.*;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {
        try {
            // Application.adresse();
            // Application.client();
            // Application.livreur();
            // Application.typeVehicule();
            // Application.taille();
            // Application.vehicule();
            Application.ingredient();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void adresse() throws SQLException {
        DaoAdresse daoAdresse = new DaoAdresse();
        System.out.println("Adresse:");
        daoAdresse.get().forEach(System.out::println);
        int res = daoAdresse.add(new Adresse(
                "CityTest",
                "RoadTest",
                111,
                "12345"
        ));
        Adresse adresse = daoAdresse.get(res);
        System.out.println("After add:\n" + adresse);
        adresse
                .setCity("Updated City")
                .setRoad("Updated Road");
        daoAdresse.update(adresse);
        System.out.println("After update:\n" + daoAdresse.get(res));
        daoAdresse.delete(res);
        System.out.println("After delete:");
        daoAdresse.get().forEach(System.out::println);
    }

    private static void client() throws SQLException {
        DaoClient daoClient = new DaoClient();
        DaoAdresse daoAdresse = new DaoAdresse();
        System.out.println("Client:");
        daoClient.get().forEach(System.out::println);
        int res = daoClient.add(new Client(
                "Paul",
                10.50f,
                0,
                daoAdresse.get(1)
        ));
        Client client = daoClient.get(res);
        System.out.println("After add:\n" + client);
        client
                .setSold(8.25f)
                .setFidelity(1);
        daoClient.update(client);
        System.out.println("After update:\n" + daoClient.get(res));
        daoClient.delete(res);
        System.out.println("After delete");
        daoClient.get().forEach(System.out::println);
    }

    private static void livreur() throws SQLException {
        DaoLivreur daoLivreur = new DaoLivreur();
        System.out.println("Livreur:");
        daoLivreur.get().forEach(System.out::println);
        int res = daoLivreur.add(new Livreur("John"));
        Livreur livreur = daoLivreur.get(res);
        System.out.println("After add:\n" + livreur);
        livreur.setName("Paul");
        daoLivreur.update(livreur);
        System.out.println("After update:\n" + daoLivreur.get(res));
        daoLivreur.delete(res);
        System.out.println("After delete");
        daoLivreur.get().forEach(System.out::println);
    }

    private static void typeVehicule() throws SQLException {
        DaoTypeVehicule daoTypeVehicule = new DaoTypeVehicule();
        System.out.println("TypeVehicule:");
        daoTypeVehicule.get().forEach(System.out::println);
        int res = daoTypeVehicule.add(new TypeVehicule("Scooter des mers"));
        TypeVehicule typeVehicule = daoTypeVehicule.get(res);
        System.out.println("After add:\n" + typeVehicule);
        typeVehicule.setName("Drone");
        daoTypeVehicule.update(typeVehicule);
        System.out.println("After update:\n" + daoTypeVehicule.get(res));
        daoTypeVehicule.delete(res);
        System.out.println("After delete");
        daoTypeVehicule.get().forEach(System.out::println);
    }

    private static void taille() throws SQLException {
        DaoTaille daoTaille = new DaoTaille();
        System.out.println("Taille:");
        daoTaille.get().forEach(System.out::println);
        int res = daoTaille.add(new Taille("Senior", 2.0f));
        Taille taille = daoTaille.get(res);
        System.out.println("After add:\n" + taille);
        taille.setName("Incroyable");
        daoTaille.update(taille);
        System.out.println("After update:\n" + daoTaille.get(res));
        daoTaille.delete(res);
        System.out.println("After delete");
        daoTaille.get().forEach(System.out::println);
    }

    private static void vehicule() throws SQLException {
        DaoVehicule daoVehicule = new DaoVehicule();
        DaoTypeVehicule daoTypeVehicule = new DaoTypeVehicule();
        System.out.println("Vehicule:");
        daoVehicule.get().forEach(System.out::println);
        int res = daoVehicule.add(new Vehicule(
                "AB-000-CD",
                daoTypeVehicule.get(1)
        ));
        Vehicule vehicule = daoVehicule.get(res);
        System.out.println("After add:\n" + vehicule);
        vehicule.setImmatriculation("AB-001-CD");
        daoVehicule.update(vehicule);
        System.out.println("After update:\n" + daoVehicule.get(res));
        daoVehicule.delete(res);
        System.out.println("After delete");
        daoVehicule.get().forEach(System.out::println);
    }

    private static void ingredient() throws SQLException {
        DaoIngredient daoIngredient = new DaoIngredient();
        System.out.println("Ingredient:");
        daoIngredient.get().forEach(System.out::println);
        int res = daoIngredient.add(new Ingredient("Ingredient"));
        Ingredient ingredient = daoIngredient.get(res);
        System.out.println("After add:\n" + ingredient);
        ingredient.setName("Ingredient updated");
        daoIngredient.update(ingredient);
        System.out.println("After update:\n" + daoIngredient.get(res));
        daoIngredient.delete(res);
        System.out.println("After delete");
        daoIngredient.get().forEach(System.out::println);
    }
}
