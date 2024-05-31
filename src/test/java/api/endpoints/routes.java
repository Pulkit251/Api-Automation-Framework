package api.endpoints;

public class routes {

    public static String base_url="https://petstore.swagger.io/v2";

    //user_model

    public static String createUser=base_url + "/user";
    public static String updateUser=base_url + "/user/{username}";
    public static String getUser=base_url + "/user/{username}";
    public static String deleteUser=base_url + "/user/{username}";

    //store_model

    public static String petInventory=base_url + "/store/inventory";
    public static String placeOrder=base_url + "/store/order";
    public static String getPurchaseOrder=base_url + "/store/order/{orderId}";
    public static String deletePurchaseOrder=base_url + "/store/order/{orderId}";

    //pet_model

    public static String addNewPet=base_url + "/pet";
    public static String getPet=base_url + "/pet/{petId}";
    public static String updatePet=base_url + "/pet/{petId}";
    public static String deletePet=base_url + "/pet/{petId}";

}
