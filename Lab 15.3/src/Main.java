import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileService<Company> companyFileService = new FileService<>();

        // đọc dữ liệu từ file
        List<Company> companies = companyFileService.readFile("company.dat");
        System.out.println("List company in file: ");
        companyFileService.printList(companies);

        Company shoppe = new Company("Sendo", "admin@sendo.com", "0456789123", "18 Science Park Drive, SENDO Building", "118456", "VietNam");
        companies.add(shoppe);

        // ghi dữ liệu mới vào file
        companyFileService.writeFile("company.dat", companies);

        // đọc dữ liệu từ file mới cập nhật
        companies = companyFileService.readFile("company.dat");
        System.out.println("List company in file: ");
        companyFileService.printList(companies);
    }
}