/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.projetoLP2.business;

import com.br.projetoLP2.model.DAO.MovieDAO;
import com.br.projetoLP2.model.Movie;

/**
 *
 * @author 31449530
 */
public class MovieManager {

    private static Movie movie = null;

    public static int insert(Movie movie) {
        MovieDAO movieDAO = new MovieDAO();

        if (movieDAO.readByName(movie.getTitle()).getId_Movie() != -1) {
            System.out.println("ERROR: Movie already exist");
            return -3;
        } else {
            boolean inserted = movieDAO.insert(movie);
            if (inserted) {
                System.out.println("Movie " + movie.getTitle() + " inserted ");
                return 1;
            } else {
                System.out.println("ERROR: user not inserted");
                return -5;
            }
        }
    }

    public static int delete(int idMovie) {
        MovieDAO movieDAO = new MovieDAO();

        Movie movie = movieDAO.readByID(idMovie);

        if (movieDAO.readByName(movie.getTitle()).getId_Movie() != -1) {
            boolean delete = movieDAO.delete(movie);

            if (delete) {
                System.out.println("Movie " + movie.getTitle() + " deleted");
                return 1;
            }
        }
        System.out.println("ERROR: Movie not deleted");
        return -5;
    }

    public static int updateTitle(int idMovie, String title) {
        MovieDAO movieDAO = new MovieDAO();

        Movie movie = movieDAO.readByID(idMovie);

        if (movie != null) {
            movie.setTitle(title);
            boolean updateTitle = movieDAO.update(movie);

            if (updateTitle) {
                System.out.println("Title updated");
                return 1;
            }
        }
        System.out.println("Title not updated");

        return -5;
    }
    
    public static int updateYear(int idMovie, int year) {
        MovieDAO movieDAO = new MovieDAO();

        Movie movie = movieDAO.readByID(idMovie);

        if (movie != null) {
            movie.setYears(year);
            boolean updateTitle = movieDAO.update(movie);

            if (updateTitle) {
                System.out.println("Year movie updated");
                return 1;
            }
        }
        System.out.println("Year movie not updated");

        return -5;
    }
    
    public static int updateDirector(int idMovie, String director) {
        MovieDAO movieDAO = new MovieDAO();

        Movie movie = movieDAO.readByID(idMovie);

        if (movie != null) {
            movie.setDirector(director);
            boolean updateTitle = movieDAO.update(movie);

            if (updateTitle) {
                System.out.println("Director updated");
                return 1;
            }
        }
        System.out.println("Director not updated");

        return -5;
    }
    
    public static int updateClassification(int idMovie, int classification) {
        MovieDAO movieDAO = new MovieDAO();

        Movie movie = movieDAO.readByID(idMovie);

        if (movie != null) {
            movie.setClassification(classification);
            boolean updateTitle = movieDAO.update(movie);

            if (updateTitle) {
                System.out.println("Classification updated");
                return 1;
            }
        }
        System.out.println("Classification not updated");

        return -5;
    }
    
    public static int updateGenre(int idMovie, String genre) {
        MovieDAO movieDAO = new MovieDAO();

        Movie movie = movieDAO.readByID(idMovie);

        if (movie != null) {
            movie.setGenre(genre);
            boolean updateTitle = movieDAO.update(movie);

            if (updateTitle) {
                System.out.println("Genre updated");
                return 1;
            }
        }
        System.out.println("Genre not updated");

        return -5;
    }
    
    public static int updateUrl(int idMovie, String url) {
        MovieDAO movieDAO = new MovieDAO();

        Movie movie = movieDAO.readByID(idMovie);

        if (movie != null) {
            movie.setUrl(url);
            boolean updateTitle = movieDAO.update(movie);

            if (updateTitle) {
                System.out.println("Url updated");
                return 1;
            }
        }
        System.out.println("Url not updated");

        return -5;
    }
}
