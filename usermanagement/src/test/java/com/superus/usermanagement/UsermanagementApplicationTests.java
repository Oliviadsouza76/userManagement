/*
 * package com.superus.usermanagement;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.mockito.ArgumentMatchers.any; import static org.mockito.Mockito.mock;
 * import static org.mockito.Mockito.when;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import javax.servlet.http.HttpServletRequest;
 * 
 * import org.json.JSONArray; import org.json.JSONException; import
 * org.json.JSONObject; import org.junit.jupiter.api.Test; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.CrossOrigin; import
 * org.springframework.web.bind.annotation.PostMapping;
 * 
 * import com.superus.usermanagement.entities.UserMaster; import
 * com.superus.usermanagement.service.UserMasterService; import
 * com.superus.usermanagement.util.Generator; import
 * com.superus.usermanagement.util.HttpRequest;
 * 
 * @SpringBootTest class UsermanagementApplicationTests {
 * 
 * @Autowired private UserMasterService userMasterService;
 * 
 * 
 * @Autowired private Generator generatorClass;
 * 
 * // @Test // void contextLoads() { // addUserData() ; // }
 * 
 * 
 * // Method Used to Test Add User Data
 * 
 * @Test public void addUserData(HttpServletRequest request) throws Exception {
 * try { JSONObject json = HttpRequest.httprequest(request); UserMaster
 * userMaster = new UserMaster(); when(json.put("name", "John")); String
 * generatedUserId = generatorClass.generateor(json.getString("name"));
 * when(json.put("email","johndoe@example.com"));
 * when(json.put("contact","1234567890")); when(json.put("city","New York"));
 * when(json.put("state","NY")); when(json.put("address","123 Main St")); //
 * 
 * UserMasterService userMasterService = mock(UserMasterService.class);
 * UserMaster mockUserMaster = mock(UserMaster.class);
 * userMaster.setUser_Id(generatedUserId);
 * userMaster.setName(json.getString("name"));
 * userMaster.setEmail_address(json.getString("email"));
 * userMaster.setContact_number(json.getLong("contact"));
 * userMaster.setCity(json.getString("city"));
 * userMaster.setState(json.getString("state"));
 * userMaster.setAddress(json.getString("address"));
 * userMasterService.addUser(userMaster);
 * when(mockUserMaster.getSize()).thenReturn(1); //
 * when(userMasterService.addUser(any(UserMaster.class))).thenReturn(
 * mockUserMaster); when(userMasterService.addUser(mockUserMaster));
 * 
 * assertEquals(1, mockUserMaster.getSize());
 * System.out.println(mockUserMaster.getSize());
 * System.out.println(mockUserMaster); }catch(IOException e) {
 * e.printStackTrace(); } //return mockUserMaster.toString(); }
 * 
 * 
 * //Test for getting Users
 * 
 * @Test public void getUserData(HttpServletRequest request) throws Exception {
 * try { JSONObject json = HttpRequest.httprequest(request); JSONArray array =
 * new JSONArray(); List<UserMaster> cmmaster = userMasterService.getAllUsers();
 * List<UserMaster> mockList = mock(List.class);
 * when(mockList.size()).thenReturn(1);
 * 
 * for(UserMaster userMaster:cmmaster) {
 * System.out.println("Data inside CMASTER>>>>>>>>>"+userMaster);
 * json.put("name", userMaster.getName()); json.put("email",
 * userMaster.getEmail_address()); json.put("contact",
 * userMaster.getContact_number()); json.put("city", userMaster.getCity());
 * json.put("state", userMaster.getState()); json.put("address",
 * userMaster.getAddress()); array.put(json); }
 * 
 * assertEquals(1, mockList.size()); System.out.println(mockList.size());
 * System.out.println(mockList); }catch(Exception e) { e.printStackTrace(); }
 * //return array.toString();
 * 
 * }
 * 
 * //Test for getting Users as per Id
 * 
 * @Test public void getUserDataByUser_ID(String user_id,HttpServletRequest
 * request) throws Exception { try { JSONObject json =
 * HttpRequest.httprequest(request); List<UserMaster> userMasterData =
 * userMasterService.getUserId(user_id); List<UserMaster> mockList =
 * mock(List.class); when(mockList.size()).thenReturn(1);
 * 
 * for (UserMaster userMaster : userMasterData) { json.put("name",
 * userMaster.getName()); json.put("email", userMaster.getEmail_address());
 * json.put("contact", userMaster.getContact_number()); json.put("city",
 * userMaster.getCity()); json.put("state", userMaster.getState());
 * json.put("address", userMaster.getAddress()); }
 * 
 * assertEquals(1, mockList.size()); System.out.println(mockList.size());
 * System.out.println(mockList); //return mockList.toString(); }catch(Exception
 * e) { e.printStackTrace(); } } }
 */