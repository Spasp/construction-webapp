package gr.pf.team2.constructionwebapp.repository;

import gr.pf.team2.constructionwebapp.domain.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PropertyRepository extends JpaRepository<Property,Long> {

    @Query(value = "SELECT * FROM Property WHERE Address = (:address)", nativeQuery = true)
    Optional<Property> findPropertyByAddress(String address);

    @Query(value = "SELECT * FROM Property WHERE Afm = (:afm)", nativeQuery = true)
    Optional<Property> findPropertyByAfm(String afm);

    @Query(value = "DELETE * FROM Property,Repair WHERE Property.Property_id=Repair.Property_id AND Property.Property_id = (:id)", nativeQuery = true)
    void deletePropertyById(Long id);

    @Query(value="SELECT * FROM Property WHERE Property.PropertyE9=(:propertyE9)", nativeQuery = true)
    List<Property> advSearchE9(String propertyE9);

    @Query(value="SELECT * FROM Property WHERE Property.Afm=(:afm)", nativeQuery = true)
    List<Property> advSearchAfm(String afm);

    @Query(value="SELECT * FROM Property WHERE Property.PropertyE9=(:propertyE9) AND Property.Afm=(:afm)", nativeQuery = true)
    List<Property> advSearchE9Afm(String propertyE9,String afm);
}
