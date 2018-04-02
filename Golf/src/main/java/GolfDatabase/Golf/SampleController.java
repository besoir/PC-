package GolfDatabase.Golf;


	import java.io.IOException;
/*
	 * To change this license header, choose License Headers in Project Properties.
	 * To change this template file, choose Tools | Templates
	 * and open the template in the editor.
	 */
	import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.scene.Parent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
	import javafx.scene.control.SplitMenuButton;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableView;
	import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

	public class SampleController implements Initializable {
		@FXML
		private MenuBar menuBar;
	    @FXML
	    private TableView<Golfer> myTableView; //need to correspond tofxid in gluconm
	    @FXML
	    private TableColumn<Golfer,String>firstNameCol;
	    @FXML
	    private TableColumn<Golfer,String>lastNameCol;
	    @FXML
	    private TableColumn<Golfer,String>teamCol;
	    @FXML
	    private TableColumn<Golfer,String>scoreCol;
	    @FXML
	    private SplitMenuButton playersFromSelectedTeam;
	    @FXML
	    private SplitMenuButton allTeams;
	    @FXML
	    private MenuItem player1; 
	    @FXML
	    private MenuItem ward;
	    
	    @FXML
	    private void handleButtonAction(ActionEvent event) {
	        System.out.println("You clicked me!");
	        
	    }
	    @FXML
	    private void setOnAction(ActionEvent e){
	    
	        System.out.println("The function was associated with the correct element");
	       }
	    @FXML
	    private void test(ActionEvent e){
	        System.out.println("The function was associated with the correct element");;}
//	    @FXML
	    @FXML
	    private void test2(ActionEvent e){
	        System.out.println("The function was associated with the correct element");
	        
	    
	    }
	       
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	        //need to modify fxml to allow for dynamic loading of players and team
	        //then connect the actions of selecting player to displaying it on the tableview
	        firstNameCol.setCellValueFactory(new PropertyValueFactory<Golfer,String>("firstName"));
	        lastNameCol.setCellValueFactory(new PropertyValueFactory<Golfer,String>("lastName"));
	        teamCol.setCellValueFactory(new PropertyValueFactory<Golfer,String>("team"));
	        scoreCol.setCellValueFactory(new PropertyValueFactory<Golfer,String>("score"));
	        this.populateTeamDropDown();
	        
	        
	        
	    }       
	    
	    public ObservableList<Golfer> getPeople(Object teamSelected){
	    ObservableList<Golfer> people = FXCollections.observableArrayList();
	    System.out.println("HEEEY");
	    
	    	Iterator<Team> ai =   Main.sec2.getTeams().iterator();
	    	while(ai.hasNext()) {
	    		Team teamTmp = ai.next();
	    		ArrayList<Golfer> arGolf = teamTmp.getAllPlayers();
	    		for(Golfer g: arGolf) {
	    			people.add(g);
	    			
	    			
	    		}
	    	}
	    return people;
	    }
	    
	     public ObservableList<MenuItem> getPlayer(){
	    ObservableList<MenuItem> players = FXCollections.observableArrayList();
	        for (int i = 0; i < 10; i++) {
	            
	        
	    players.add(new MenuItem("example of adding menu item"));
	        }return players;
	    }
	    
	    public void testSb(){
	    	Main.sec2.printMap();
	        playersFromSelectedTeam.setText("fight against grenade spam");
	        
	    }
	    
	    private void populateTeamDropDown() {
	    	 ObservableList<MenuItem> teams = FXCollections.observableArrayList();
	    	Iterator<Team> ai =   Main.sec2.getTeams().iterator();
	    	while(ai.hasNext()) {
	    		Team teamTmp = ai.next();
	    		MenuItem mu = new MenuItem(teamTmp.getTeamName());
	    		mu.setOnAction(new EventHandler<ActionEvent>() {

					public void handle(ActionEvent event) {
					populatePlayerDropDown(event.getSource()); //WHERE WE FILL THE PLAYER SMB
					MenuItem mi = (MenuItem)(event.getSource());
						allTeams.setText(mi.getText());
					}
	    			
	    			
	    		});

	    	teams.add(mu);}
	    	allTeams.getItems().addAll(teams);
	    }
	    
	    public void populatePlayerDropDown(Object menuClicked) {
	    	playersFromSelectedTeam.getItems().clear();
	    	MenuItem mu = (MenuItem) menuClicked;
	    	ObservableList<MenuItem> people = FXCollections.observableArrayList();
	    ArrayList<Golfer> players=	Main.sec2.getSelectedTeam(mu.getText());
	    	if(!(players == null)) {
	    		for(Golfer g: players) {
	    			MenuItem mi = new MenuItem(g.getFirstName());
	    			mi.setOnAction(new EventHandler<ActionEvent>(){
	    				public void handle(ActionEvent e)  {
	    					try {
								changeScene(e);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	    					
	    			}});
	    			people.add(mi);}
	    			
	    			
	    		}
	    		playersFromSelectedTeam.getItems().addAll(people);	
	    		myTableView.getItems().clear();
	    		myTableView.getItems().addAll(players);
	    		
	    	}
	    public void changeScene(ActionEvent e) throws IOException {
	    	Parent table2;
			
			table2 = FXMLLoader.load(getClass().getResource("/second.fxml"));
		Scene tableScene = new Scene(table2);
		 Stage app_stage = (Stage )menuBar.getScene().getWindow();
		
		app_stage.setScene(tableScene);
		app_stage.setTitle("First comment");
		app_stage.show();
	    	
	    	
	    }
	    	}
	    	