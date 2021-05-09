package sp.sample.simpleCurd.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;
import sp.sample.simpleCurd.dao.DataObject;
import sp.sample.simpleCurd.exception.SampleRunTimeException;
import sp.sample.simpleCurd.repository.DataAccessCurdRepository;

@RunWith(MockitoJUnitRunner.class)
public class DataAccessServiceTest {

    @Mock
    private DataAccessCurdRepository dataAccessCurdRepository;

    @InjectMocks
    private DataAccessService dataAccessService;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(dataAccessService,"dataAccessCurdRepository",dataAccessCurdRepository);
    }

    @Test
    public void insertsString_when_DataObjectIsPassed() {
        DataObject dataObject = new DataObject();
        dataObject.setItem("1");
        Mockito.when(dataAccessCurdRepository.save(dataObject))
                .thenReturn(dataObject);
        String insertedValue = dataAccessService.insertObject(dataObject);
        Assert.assertEquals(insertedValue,dataObject.getItem());
    }

    @Test(expected = SampleRunTimeException.class)
    public void throwsException_when_saveingDataIsFailed() {
        DataObject dataObject = new DataObject();
        dataObject.setItem("1");
        Mockito.when(dataAccessCurdRepository.save(dataObject))
                .thenReturn(null);
        String insertedValue = dataAccessService.insertObject(dataObject);
        Assert.assertEquals(insertedValue,dataObject.getItem());
    }
}