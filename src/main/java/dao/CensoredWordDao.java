package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CensoredWordDao extends BaseDao {

    public List<String> getUnhealthyWords() {
        List<String> words = new ArrayList<>();
        try {
            String sql = "SELECT filtered_word from filtered_words_tbl";
            ResultSet set = getConnection().prepareStatement(sql).executeQuery();
            while (set.next()) {
                words.add(set.getString("filtered_word"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return words;
    }

    public boolean removeWord(String word) {
        boolean removed = false;
        try {
            String sql = "delete from filtered_words_tbl where filtered_word = '"+word+"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            removed = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return removed;

    }

    public boolean updateWord(String oldWord, String newWord) {
        boolean updated = false;
        try {
            String sql = "update filtered_words_tbl set filtered_word = '"+newWord+
                    "' where filtered_word ='"+oldWord+"'";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            updated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public boolean addWord(String word) {
        boolean added = false;
        try {
            String sql = "INSERT INTO filtered_words_tbl (filtered_word) VALUES (?)";
            PreparedStatement statement = getConnection().prepareStatement(sql);
            statement.setString(1, word);
            added = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return added;
    }
}
