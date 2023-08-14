package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.domain.InhousePart;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        //Check if repositories are empty before creating default inventory.
        if (partRepository.count() == 0 && productRepository.count() == 0 && outsourcedPartRepository.count() == 0) {

            //Create default products
            Product computer = new Product("GC 100", 350.96, 20);
            Product computer2 = new Product("GC 200", 471.95, 10);
            Product computer3 = new Product("GC 300", 721.94, 15);
            Product computer4 = new Product("GC 400", 951.90, 5);
            Product computer5 = new Product("GC 500", 1309.90, 10);

            //Create default parts
            OutsourcedPart ram = new OutsourcedPart("RAM 8GB DDR4", 20.0, 10, "Corsair", 0, 30);
            OutsourcedPart ram2 = new OutsourcedPart("RAM 16GB DDR4", 40.0, 10, "Corsair", 0, 30);

            OutsourcedPart motherBoard = new OutsourcedPart("H610M-G Micro ATX Motherboard", 79.99, 10, "MSI", 0, 30);
            OutsourcedPart motherBoard2 = new OutsourcedPart("MPG Z690 WiFi Gaming Motherboard", 249.95, 10, "MSI", 0, 30);

            OutsourcedPart graphics = new OutsourcedPart("Dual GeForce RTX 3050 OC Graphics Card", 229.99, 8, "ASUS", 0, 30);
            OutsourcedPart graphics2 = new OutsourcedPart("GeForce RTX 4060 Ti Graphics Card", 399.99, 6, "MSI", 0, 30);

            OutsourcedPart cpu = new OutsourcedPart("12100 4 Core CPU", 155.00, 3, "Intel", 0, 30);
            OutsourcedPart cpu2 = new OutsourcedPart("12700K 12 Core CPU", 275.99, 12, "Intel", 0, 30);
            OutsourcedPart cpu3 = new OutsourcedPart("12900KS 16 Core CPU", 419.99, 4, "Intel", 0, 30);

            InhousePart fan = new InhousePart("Standard CPU fan", 35.99, 18, 0, 30);
            InhousePart fan2 = new InhousePart("Premium high output CPU fan", 79.99, 9, 0, 30);

            InhousePart case1 = new InhousePart("Micro ATX case", 39.99, 4, 0, 30);
            InhousePart case2 = new InhousePart("Full Sized Case", 79.99, 5);

            OutsourcedPart hardDrive = new OutsourcedPart("480GB SSD Hard Drive", 19.99, 13, "Somnambulist", 0, 30);
            OutsourcedPart hardDrive2 = new OutsourcedPart("1TB SSD Hard Drive", 39.99, 8, "Samsung", 0, 30);

            //Save products.
            productRepository.save(computer);
            productRepository.save(computer2);
            productRepository.save(computer3);
            productRepository.save(computer4);
            productRepository.save(computer5);

            //Set Products to parts which maps to PRODUCT_PART
            ram.setProducts(new HashSet<>(List.of(computer, computer2)));
            ram2.setProducts(new HashSet<>(List.of(computer3, computer4, computer5)));
            motherBoard.setProducts(new HashSet<>(List.of(computer, computer2, computer3)));
            motherBoard2.setProducts(new HashSet<>(List.of(computer4, computer5)));
            cpu.setProducts(new HashSet<>(List.of(computer)));
            cpu2.setProducts(new HashSet<>(List.of(computer2, computer3, computer4)));
            cpu3.setProducts(new HashSet<>(List.of(computer5)));
            fan.setProducts(new HashSet<>(List.of(computer, computer2, computer3, computer4)));
            fan2.setProducts(new HashSet<>(List.of(computer5)));
            graphics.setProducts(new HashSet<>(List.of(computer3, computer4)));
            graphics2.setProducts(new HashSet<>(List.of(computer5)));
            case1.setProducts(new HashSet<>(List.of(computer, computer2, computer3)));
            case2.setProducts(new HashSet<>(List.of(computer4, computer5)));
            hardDrive.setProducts(new HashSet<>(List.of(computer, computer2, computer3)));
            hardDrive2.setProducts(new HashSet<>(List.of(computer4, computer5)));

            //Persist parts after mapping PRODUCT_PART
            outsourcedPartRepository.save(ram);
            outsourcedPartRepository.save(ram2);
            outsourcedPartRepository.save(motherBoard);
            outsourcedPartRepository.save(motherBoard2);
            outsourcedPartRepository.save(graphics);
            outsourcedPartRepository.save(graphics2);
            outsourcedPartRepository.save(cpu);
            outsourcedPartRepository.save(cpu2);
            outsourcedPartRepository.save(cpu3);
            partRepository.save(fan);
            partRepository.save(fan2);
            partRepository.save(case1);
            partRepository.save(case2);
            outsourcedPartRepository.save(hardDrive);
            outsourcedPartRepository.save(hardDrive2);

            //Set parts on products. 
            computer.setParts(new HashSet<>(List.of(ram, motherBoard, cpu, fan, case1, hardDrive)));
            computer2.setParts(new HashSet<>(List.of(ram, motherBoard, cpu2, fan, case1, hardDrive)));
            computer3.setParts(new HashSet<>(List.of(ram2, motherBoard, cpu2, graphics, fan, case1, hardDrive)));
            computer4.setParts(new HashSet<>(List.of(ram2, motherBoard2, cpu2, fan, graphics, case2, hardDrive2)));
            computer5.setParts(new HashSet<>(List.of(ram2, motherBoard2, cpu3, fan2, graphics2, case2, hardDrive2)));
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
