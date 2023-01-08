package ru.levelup.lesson7.dao.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.levelup.lesson7.dao.CityDao;
import ru.levelup.lesson7.model.City;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CityDaoImpl implements CityDao {

    private final NamedParameterJdbcOperations jdbcOperations;
    private final RowMapper<City> cityRowMapper =
            (rs, row) -> new City(rs.getInt("id"), rs.getString("name_ru"),
                    rs.getString("name_en"), rs.getInt("population"));

    @Override
    public List<City> findAll() {
        //language=SQL
        final String sql = "SELECT * FROM city d";
        return jdbcOperations.query(sql, cityRowMapper);
    }

    @Override
    public Optional<City> getById(int id) {
        //language=SQL
        String sql = "SELECT * FROM city d " +
                "where d.id = :id";
        try {
            return Optional.of(jdbcOperations.queryForObject(sql, Map.of("id", id), cityRowMapper));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public int create(City city) {
        //language=SQL
        final String sqlQuery = "insert into city (id, name_ru, name_en, population) " +
                "values (:id, :name_ru, name_en, population)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        final Integer id = city.getId();
        namedParameters.addValue("id", id, Types.INTEGER);
        namedParameters.addValue("name_ru", city.getNameRu(), Types.VARCHAR);
        namedParameters.addValue("name_en", city.getNameEn(), Types.VARCHAR);
        namedParameters.addValue("population", city.getPopulation(), Types.INTEGER);
        jdbcOperations.update(sqlQuery, namedParameters);
        return id;
    }

    @Override
    public void update(City city) {
        //language=SQL
        final String sqlQuery = "update city set name_ru = :name_ru, name_en = :name_en, population = :population " +
                "where id = :id";
        jdbcOperations.update(sqlQuery, Map.of(
                "id", city.getId(),
                "name_ru", city.getNameRu(),
                "name_en", city.getNameEn(),
                "population", city.getPopulation()));
    }

    @Override
    public void deleteById(int id) {
        //language=SQL
        String sqlQuery = "delete from city d where d.id = :id";
        jdbcOperations.update(sqlQuery, Map.of("id", id));
    }
}