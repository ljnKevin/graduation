package dao;

import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import model.NoteBookItem;

@Repository
@Table(name="NoteBookItem")
@Qualifier("noteBookItemRepository")
public interface noteBookItemRepository extends CrudRepository<NoteBookItem, Long > {

    public NoteBookItem findOne(Long id);

    public NoteBookItem save(NoteBookItem item);

    @Query("select t from User t where t.userName=:name")
    public NoteBookItem findUserByName(@Param("name") String name);
}
