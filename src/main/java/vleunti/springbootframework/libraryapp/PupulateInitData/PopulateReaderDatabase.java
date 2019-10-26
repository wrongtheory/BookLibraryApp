package vleunti.springbootframework.libraryapp.PupulateInitData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;
import vleunti.springbootframework.libraryapp.services.ReaderService;
import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateDatabase implements ApplicationListener<ContextRefreshedEvent> {

    public ReaderRepository readerRepository;

    @Autowired
    public ReaderService readerService;

    @Autowired
    public PopulateDatabase(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    List<Reader> readerList = new ArrayList<>();

    public List<Reader> getReaderList() {
        readerList.add(new Reader("Java","8","gmail",1945L,"keine", "2019-09-01"));
        readerList.add(new Reader("John","Smith","js@yahoo.com",1990L,"Reaver Street 1", "2019-08-01"));
        readerList.add(new Reader("Michael","Snow","snow@gmail.com",1989L,"Boehlener Strasse 33", readerService.getCurrentDate()));
        readerList.add(new Reader("Mike","Levis","mike@mail.com",12345L,"No street", "2018-04-03"));
        readerList.add(new Reader("Lola","Reve","lola@java.md",6789L,"Museum Strasse 12",readerService.getCurrentDate()));
        readerList.add(new Reader("Andreas","Still","andreas@andreas.com",2019L,"Rene Strasse 9", readerService.getCurrentDate()));
        readerList.add(new Reader("Mona","Lisa","mona@gmail.com",10011989L,"Landsberger Strasse 78", readerService.getCurrentDate()));
        readerList.add(new Reader("Jurii","Vdovenko","iura@yahoo.com",14578L,"Bahnhof Strasse 4", readerService.getCurrentDate()));
        readerList.add(new Reader("Simon","Hz","simon@gmail.com",3698L,"keine", readerService.getCurrentDate()));
        readerList.add(new Reader("Lilu","Ojo","llovo@yahoo.com",1238L,"Geverbegebiet Strasse 12", "2017-12-02"));

        for(int i=0;i<readerList.size();i++) {
            readerRepository.save(readerList.get(i));
        }
        return readerList;
    }

    public void initData(){
        getReaderList();
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
