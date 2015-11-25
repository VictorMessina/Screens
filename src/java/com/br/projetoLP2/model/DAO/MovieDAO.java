package com.br.projetoLP2.model.DAO;

import com.br.projetoLP2.model.Movie;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Victor Messina TIA: 31449530, Leticia Garcia TIA: 31402836 , Filippi Di Pipi TIA: 31438938
 */
public class MovieDAO implements GenericDAO<Movie> {

    private Connection conn;

    public MovieDAO() {
        this.conn = ConnectionDB.getInstance();
    }

    @Override
    public boolean insert(Movie movie) {
        boolean resp = false;

        String sql = "insert into Movie_ (title,years,director,classification,genre,url) values(?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getYears());
            ps.setString(3, movie.getDirector());
            ps.setInt(4, movie.getClassification());
            ps.setString(5, movie.getGenre());
            ps.setString(6, movie.getUrl());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel registar sua conta");
            } else {
                System.out.println("Registrado com sucesso");
                resp = true;
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Movie> read() {
        List<Movie> movies = new ArrayList<>();

        String sql = "select * from Movie_";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_Movie = rs.getInt("id_Movie");
                String title = rs.getString("title");
                int years = rs.getInt("years");
                String director = rs.getString("director");
                int classification = rs.getInt("classification");
                String genre = rs.getString("genre");
                String url = rs.getString("url");
                Movie movie = new Movie(id_Movie, title, years, director, classification, genre,url);
                movies.add(movie);
            }
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movies;
    }

    public Movie readByName(String title) {
        Movie movie = new Movie();
        //2 - criar String SQL
        String sql = "Select * from Movie_ where title=?";
        try {
            //2a - criar o preparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);

            //3- executa a query 
            ResultSet rs = ps.executeQuery(); // retorna um objeto do tipo resultSet (grande objeto, 
            // mapa de registros do banco)

            //4 - mostrar os resultados do resutSet
            while (rs.next()) {
                movie.setId_Movie(rs.getInt("id_Movie"));
                movie.setTitle(rs.getString("title"));
                movie.setYears(rs.getInt("years"));
                movie.setDirector(rs.getString("director"));
                movie.setClassification(rs.getInt("classification"));
                movie.setGenre(rs.getString("genre"));
                movie.setUrl(rs.getString("url"));
            }
            //5-fecha a conexao com o DB e com o PerparedStatement
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movie;
    }
    public Movie readByID(int idMovie) {
        Movie movie = new Movie();
        //2 - criar String SQL
        String sql = "Select * from Movie_ where id_Movie=?";
        try {
            //2a - criar o preparedStatement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,idMovie);

            //3- executa a query 
            ResultSet rs = ps.executeQuery(); // retorna um objeto do tipo resultSet (grande objeto, 
            // mapa de registros do banco)

            //4 - mostrar os resultados do resutSet
            while (rs.next()) {
                movie.setId_Movie(rs.getInt("id_Movie"));
                movie.setTitle(rs.getString("title"));
                movie.setYears(rs.getInt("years"));
                movie.setDirector(rs.getString("director"));
                movie.setClassification(rs.getInt("classification"));
                movie.setGenre(rs.getString("genre"));
                movie.setUrl(rs.getString("url"));
            }
            //5-fecha a conexao com o DB e com o PerparedStatement
            ps.close();
            rs.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return movie;
    }

    @Override
    public boolean update(Movie movie) {
        boolean resp = false;

        String sql = "update Movie_ set title=?,years=?,director=?,classification=?,genre=?,url=? where id_Movie=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setString(1, movie.getTitle());
            ps.setInt(2, movie.getYears());
            ps.setString(3, movie.getDirector());
            ps.setInt(4, movie.getClassification());
            ps.setString(5, movie.getGenre());
            ps.setString(6,movie.getUrl());
            ps.setInt(7, movie.getId_Movie());

            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Falha ao atualizar os dados do filme");
            } else {
                System.out.println("Dados do filme atualizados com sucesso");
                resp = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }

    @Override
    public boolean delete(Movie movie) {
        boolean resp = false;

        String sql = "delete from Movie_ where id_Movie=?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, movie.getId_Movie());
            int resposta = ps.executeUpdate();

            if (resposta == 0) {
                System.out.println("Não foi possivel excluir o filme indicado");
            } else {
                System.out.println("filme excluido com sucesso");
                resp = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resp;
    }
}