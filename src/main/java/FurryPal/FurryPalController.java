package FurryPal;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

@Controller
public class FurryPalController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AdminRepo adminRepo;

    @Autowired
    SurveyRepo surveyRepo;

    @Autowired
    PetsRepo petsRepo;

    @Autowired
    UserRegsPetRepo userregspetRepo;

    @Autowired
    ContactRepo contactRepo;

    @Autowired
    ServicesRepo servicesRepo;

    @Autowired
    PetService petService;
    
    @GetMapping(value="FurryPal/home")
    public String homePage() {
        return "home";
    }
    
    @RequestMapping(value="FurryPal/vet")
    public String vet(Model model) {
        List<Services> vetServices = servicesRepo.findByType("Vet");
        model.addAttribute("services", vetServices);
        return "vet";
    }
    
    @RequestMapping(value="FurryPal/training")
    public String training(Model model) {
        List<Services> trainingServices = servicesRepo.findByType("Trainer");
        model.addAttribute("services", trainingServices);
        return "training";
    }

    @RequestMapping(value="FurryPal/grooming")
    public String grooming(Model model) {
        List<Services> groomingServices = servicesRepo.findByType("Groomer");
        model.addAttribute("services", groomingServices);
        return "grooming";
    }

    @RequestMapping(value="FurryPal/petwatching")
    public String petwatching(Model model) {
        List<Services> petWatchingServices = servicesRepo.findByType("PetWatcher");
        model.addAttribute("services", petWatchingServices);
        return "petwatching";
    }

    @RequestMapping(value="/admin")
    public String admin(){
        return "admin";
    }

    @GetMapping(value="FurryPal/adoptionform")
    public String adoption(Model model){
        model.addAttribute("user", new User());
        return "adoptionform";
    }

    @PostMapping(value="FurryPal/adoptionsuccess") 
    public String adoptionRes(@ModelAttribute User user,Model model) {
        model.addAttribute("user",user);
        userRepo.save(user);
        return "adoptionsuccess";
    }

    @GetMapping(value="FurryPal/admin/dashboard")
    public String adoptionresult(Model model){
        List<User> user = userRepo.findAll();
        model.addAttribute("user", user);
        return "admin";
    }

    @GetMapping("FurryPal/catgy")
    public String catgy(Model model) {
        List<Pets> pets = petsRepo.findAll();
        model.addAttribute("pets", pets);
        return "catgy";
    }

    @RequestMapping(value="FurryPal/cat")
    public String cat(Model model) {
        List<Pets> cats = petsRepo.findByType("Cat");
        model.addAttribute("pets", cats);
        return "cat";
    }
    
    @RequestMapping(value="FurryPal/dog")
    public String dog(Model model) {
        List<Pets> dogs = petsRepo.findByType("Dog");
        model.addAttribute("pets", dogs);
        return "dog";
    }

    @RequestMapping(value="FurryPal/add")
    public String add(){
        return "add";
    }

    @RequestMapping(value="FurryPal/blog")
    public String blog(){
        return "Blog";
    }

    @RequestMapping(value="FurryPal/donate")
    public String donate(){
        return "donate";
    }

    @RequestMapping(value="FurryPal/Donation")
    public String afterDonation(){
        return "afterDonation";
    }

    @RequestMapping(value="FurryPal/buttonb4register")
    public String buttonb4register(){
        return "buttonb4register";
    }

    @RequestMapping(value="FurryPal/login")
    public String login(){
        return "login";
    }    

    @GetMapping(value="FurryPal/survey")
    public String survey(Model model){
        model.addAttribute("survey", new Survey());
        return "survey";
    }

    @PostMapping(value="FurryPal/surveyresult") 
    public String surveyRes(@ModelAttribute Survey ob,Model model) {
        model.addAttribute("ob",ob);
        surveyRepo.save(ob);
        return "home";
    }

    @GetMapping(value="FurryPal/registerpet")
    public String registerpet(Model model){
        model.addAttribute("ob", new UserRegsPet());
        return "registerpet";
    }

    @RequestMapping("FurryPal/userRegsPet/save")
    public RedirectView saveUserRegsPet(UserRegsPet ob,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        ob.setPhotos(fileName);
         
        UserRegsPet savedUser = userregspetRepo.save(ob);
 
        String uploadDir = "pet-photos/" + savedUser.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("FurryPal/admin/UserRegsPet", true);
    }

    @GetMapping("FurryPal/admin/UserRegsPet") 
    public String getUserRegsPet(Model model) {
        List<UserRegsPet> ob = userregspetRepo.findAll();
        model.addAttribute("ob", ob);
        return "adminuserregspet";
    }

    @GetMapping(value="FurryPal/admin/addpet")
    public String addpet(Model model){
        model.addAttribute("pets", new Pets());
        return "adminpet";
    }

    @RequestMapping("/pets/save")
    public RedirectView saveUser(Pets pets,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        pets.setPhotos(fileName);
         
        Pets savedUser = petsRepo.save(pets);
 
        String uploadDir = "pet-photos/" + savedUser.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
         
        return new RedirectView("FurryPal/admin/addpetRes", true);
    }

    @GetMapping("/pets/FurryPal/admin/addpetRes")
    public String getPets(Model model) {
        List<Pets> pets = petsRepo.findAll();
        model.addAttribute("pets", pets);
        return "editpets";
    }

    @GetMapping("/FurryPal/userRegsPet/FurryPal/admin/UserRegsPet")
    public String regspetsuccess(Model model){
        return "regspetsuccess";
    }

    @GetMapping("FurryPal/admin/addpetRes")
    public String getUsers(Model model) {
        List<Pets> pets = petsRepo.findAll();
        model.addAttribute("pets", pets);
        return "catgy";
    }

    @GetMapping("FurryPal/admin/editpet")
    public String editPet(Model model) {
        List<Pets> pets = petsRepo.findAll();
        model.addAttribute("pets", pets);
        return "editpets";
    }

    @GetMapping("/FurryPal/admin/editpet/delete/{id}")
    public String deletePet(@PathVariable Integer id) {
        petsRepo.deleteById(id);
        return "redirect:/FurryPal/admin/editpet";
    }

    @GetMapping("/FurryPal/admin/editpet/update/{id}")
    public String updatePet(@PathVariable Integer id, Model model) {
        Optional<Pets> optionalPet = petsRepo.findById(id);
        if (optionalPet.isPresent()) {
            model.addAttribute("pet", optionalPet.get());
            return "updatepet";
        } else {
            return "redirect:/FurryPal/admin/editpet";
        }
    }

    @PostMapping("/FurryPal/admin/editpet/update/{id}")
    public String savePet(@ModelAttribute Pets pet) {
        petsRepo.save(pet);
        return "redirect:/FurryPal/admin/editpet";
    }

    @GetMapping("/FurryPal/admin/editemployee/delete/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        servicesRepo.deleteById(id);
        return "redirect:/FurryPal/admin/editemployee";
    }

    @GetMapping("/FurryPal/admin/editemployee/update/{id}")
    public String updateEmp(@PathVariable Integer id, Model model) {
        Optional<Services> optionalPet = servicesRepo.findById(id);
        if (optionalPet.isPresent()) {
            model.addAttribute("emp", optionalPet.get());
            return "updateemp";
        } else {
            return "redirect:/FurryPal/admin/editemployee";
        }
    }

    @PostMapping("/FurryPal/admin/editemployee/update/{id}")
    public String saveEmp(@ModelAttribute Services emp) {
        servicesRepo.save(emp);
        return "redirect:/FurryPal/admin/editemployee";
    }

    @GetMapping(value="FurryPal/contact")
    public String contact(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping(value="FurryPal/contactsuccess") 
    public String contactRes(@ModelAttribute Contact contactform,Model model) {
        model.addAttribute("contactform",contactform);
        contactRepo.save(contactform);
        return "contactsuccess";
    }
 
    @GetMapping("FurryPal/admin/contact")
    public String contactRes(Model model) {
        List<Contact> contact = contactRepo.findAll();
        model.addAttribute("contact", contact);
        return "admincontact";
    }

    @GetMapping(value="FurryPal/admin/addemployee")
    public String addemployee(Model model){
        model.addAttribute("services", new Services());
        return "adminemployee";
    }

    @PostMapping(value="FurryPal/admin/addemployeeRes") 
    public String addemployeeRes(@ModelAttribute Services ob2,Model model)throws IOException {
        model.addAttribute("ob2",ob2);
        servicesRepo.save(ob2);
        return "editemployee";
    }

    @GetMapping("FurryPal/admin/editemployee")
    public String editEmp(Model model) {
        List<Services> services = servicesRepo.findAll();
        model.addAttribute("services", services);
        return "editemployee";
    }
    
}