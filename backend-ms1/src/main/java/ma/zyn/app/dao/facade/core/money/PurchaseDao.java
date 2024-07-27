package ma.zyn.app.dao.facade.core.money;

import org.springframework.data.jpa.repository.Query;
import ma.zyn.app.zynerator.repository.AbstractRepository;
import ma.zyn.app.bean.core.money.Purchase;
import org.springframework.stereotype.Repository;
import ma.zyn.app.bean.core.money.Purchase;
import java.util.List;


@Repository
public interface PurchaseDao extends AbstractRepository<Purchase,Long>  {
    Purchase findByReference(String reference);
    int deleteByReference(String reference);

    List<Purchase> findByClientId(Long id);
    int deleteByClientId(Long id);
    long countByClientId(Long id);

    @Query("SELECT NEW Purchase(item.id,item.reference) FROM Purchase item")
    List<Purchase> findAllOptimized();

}
