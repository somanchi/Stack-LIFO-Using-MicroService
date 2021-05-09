package sp.sample.simpleCurd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sp.sample.simpleCurd.dao.DataObject;
import sp.sample.simpleCurd.exception.SampleRunTimeException;
import sp.sample.simpleCurd.repository.DataAccessCurdRepository;

@Service
public class DataAccessService {

    @Autowired
    public DataAccessCurdRepository dataAccessCurdRepository;


    public String insertObject(DataObject dataObject) {
        try {
            return  dataAccessCurdRepository.save(dataObject).getItem();
        }
        catch (Exception e){
            throw new SampleRunTimeException(HttpStatus.NOT_IMPLEMENTED, "failed To insert");
        }
    }

    public String deleteObject() {
        try {
            DataObject top = dataAccessCurdRepository.findTop1ByOrderByIdDesc();
            dataAccessCurdRepository.deleteById(top.getId());
            return top.getItem();
        }
        catch (Exception e ) {
            throw new SampleRunTimeException(HttpStatus.NOT_IMPLEMENTED, "Top element not found");
        }
    }
}
