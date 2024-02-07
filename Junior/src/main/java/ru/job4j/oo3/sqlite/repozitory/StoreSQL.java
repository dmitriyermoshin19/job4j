package ru.job4j.oo3.sqlite.repozitory;

import ru.job4j.oo3.sqlite.config.Config;
import ru.job4j.oo3.sqlite.util.createxml.Entry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection conn;

    public StoreSQL(Config config) {
        this.config = config;
        config.init();
        this.init();
    }

    /**
     * метод создает подключение к базе данных, если таблица существует,
     * если таблицы нет, то создает ее. Если таблица есть, то удаляет все данные в ней.
     */
    public void init() {
        try {
            this.conn = DriverManager.getConnection(config.get("url"));
            Statement st = this.conn.createStatement();
            st.executeUpdate("CREATE TABLE IF NOT EXISTS entry(field INTEGER)");
            st.executeUpdate("DELETE FROM entry");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод генерирует в базе(таблице) n записей. Ввод данных через цикл for.
     * addBatch() добавляет отдельный sql запрос в "пакет"
     * executeBatch() выполнение всех запросов, находящихся в "пакете"
     * .setAutoCommit(false) Отмена автоматической фиксации транзакции
     * .commit() - завершение всех изменений в БД
     * .setAutoCommit(true) восстановленте по умолчанию
     * .rollback() откат к начальному состоянии базы, если не удалось закомитить запросы
     *
     * @param n - количество записей, которые требуется сгенерировать в базу.
     */
    public void generate(int n) {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO entry VALUES (?)")) {
            this.conn.setAutoCommit(false);
            for (int i = 1; i <= n; i++) {
                ps.setInt(1, i);
                ps.addBatch();
            }
            try {
                ps.executeBatch();
                conn.commit();
            } catch (SQLException e1) {
                conn.rollback();
                e1.printStackTrace();
            }
            this.conn.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * метод передает все элементы из таблицы entry в коллекцию с классом <Entry>
     *
     * @return List<Entry>
     */
    public List<Entry> load() {
        List<Entry> result = new ArrayList<>();
        try (Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM entry");
            while (rs.next()) {
                result.add(new Entry(rs.getInt("field")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}
