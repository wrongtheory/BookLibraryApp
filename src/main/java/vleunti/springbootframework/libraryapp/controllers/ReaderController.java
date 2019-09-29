package vleunti.springbootframework.libraryapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vleunti.springbootframework.libraryapp.models.Reader;
import vleunti.springbootframework.libraryapp.models.repositories.ReaderRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ReaderController {


    ReaderRepository readerRepository;

    @Autowired
    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    @GetMapping("/readers")
    public String getClientsPage(){
        return "readers";
    }

    @Primary
    @GetMapping("/addreader")
    public String viewForm(){
        return "addreader";
    }

    @PostMapping(value="/addreader")
    public String saveReader(@ModelAttribute("reader") @Valid  Reader reader,BindingResult bindingResult, Model model){
        model.addAttribute("reader", readerRepository.save(reader));
        //readerRepository.save(reader);
        //reader.setFirstname("fdsfsd");
        //List<Reader> reader2 =readerRepository.findByidNumber(reader.getId());
        //bindingResult.getModel();

        return "addreader";
    }





}
