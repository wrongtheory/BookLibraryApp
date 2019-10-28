package vleunti.springbootframework.libraryapp.populateInitData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class PopulateDatabaseWithReaders implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public ReaderRepository readerRepository;

    List<Reader> readerList = new ArrayList<>();

    public List<Reader> getReaderList() {
        readerList.add(new Reader("Ed","Smith","ed@gmail",95874L,"keine", LocalDate.now()));
        readerList.add(new Reader("Robert","Price","rprice@yahoo.com",48792L,"Reaver Street 1", LocalDate.now()));
        readerList.add(new Reader("Michael","Snow","snow@gmail.com",96321L,"Boehlener Strasse 33", LocalDate.parse("2019-09-09", DateTimeFormatter.ISO_DATE)));
        readerList.add(new Reader("Mike","Levis","mike@mail.com",74854L,"No street", LocalDate.parse("2015-10-01", DateTimeFormatter.ISO_DATE)));
        readerList.add(new Reader("Lola","Reve","lola@java.md",78923L,"Museum Strasse 12",LocalDate.now()));
        readerList.add(new Reader("Andreas","Still","andreas@andreas.com",20192L,"Rene Strasse 9", LocalDate.parse("2017-10-01", DateTimeFormatter.ISO_DATE)));
        readerList.add(new Reader("Mona","Lisa","mona@gmail.com",10011L,"Landsberger Strasse 78", LocalDate.now()));
        readerList.add(new Reader("Jurii","Vdovenko","iura@yahoo.com",19574L,"Bahnhof Strasse 4", LocalDate.now()));
        readerList.add(new Reader("Simon","Hz","simon@gmail.com",36698L,"keine", LocalDate.parse("2018-02-22", DateTimeFormatter.ISO_DATE)));
        readerList.add(new Reader("Lilu","Ojo","llovo@yahoo.com",12538L,"Geverbegebiet Strasse 12", LocalDate.parse("2011-06-13", DateTimeFormatter.ISO_DATE)));

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
