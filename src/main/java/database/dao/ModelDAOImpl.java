package database.dao;

import aquality.selenium.core.logging.Logger;
import database.DBConnection;
import database.table.models.Model;
import database.table.models.Project;
import lombok.SneakyThrows;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelDAOImpl<T> implements ModelDAO<T> {
    protected final Connection connection = DBConnection.getConnection();

    public ModelDAOImpl() {
    }

    @Override
    public T get(long id, Class<T> modelClass, String sql) {
        Model model = getModelInstance(modelClass);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                model = model.getModelFromResultSet(resultSet);
            }
        }
        catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
        return (T) model;
    }

    @Override
    public List<T> getAll(Class<T> modelClass, String sql) {
        Model model = getModelInstance(modelClass);
        List<T> allModels = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                allModels.add((T) model.getModelFromResultSet(resultSet));
            }
        }
        catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
        return allModels;
    }

    @Override
    public void create(Class<T> modelClass, String sql, Model modelToCreate) {
        Model model = getModelInstance(modelClass);
        int generatedId = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            model.prepareStatementForEdit(preparedStatement, modelToCreate);
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            generatedId = resultSet.getInt(1);
        }
        catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
        modelToCreate.setId(generatedId);
    }

    @Override
    public void update(Model modelToUpdate, int positionId, Class<T> modelClass, String sql) {
        Model model = getModelInstance(modelClass);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            model.prepareStatementForEdit(preparedStatement, modelToUpdate);
            preparedStatement.setLong(positionId, modelToUpdate.getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }

    @Override
    public void delete(long id, String sql) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            Logger.getInstance().error("SQLException : " + e);
        }
    }

    @SneakyThrows
    private Model getModelInstance(Class<T> modelClass) {
        return (Model) modelClass.getDeclaredConstructor().newInstance();
    }

}
