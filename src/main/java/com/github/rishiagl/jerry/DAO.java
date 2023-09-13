package com.github.rishiagl.jerry;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public interface DAO<Entity, EntityProperty> {
    public long addOne(Entity e) throws SQLException;
    public boolean updateOne(Entity e) throws SQLException;
    public boolean deleteOne(Entity e) throws SQLException;

    public List<Entity> getAll() throws SQLException;
    public List<Entity> getByProperty(EntityProperty p, Object value) throws SQLException;
}
