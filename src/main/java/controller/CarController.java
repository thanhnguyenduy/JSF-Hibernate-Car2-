package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Dao.CarDao;
import entity.Car;


@ManagedBean(name="control")
@SessionScoped
public class CarController {
	private CarDao carDao = new CarDao();
	
	private Car car = new Car();
	//private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	private List<Car> listCar = new ArrayList<Car>();
	
	public CarController() {
		getListCar();
	}
	
	public List<Car> getListCar(){
		listCar=carDao.getAllCars();
		return listCar;
	}
	
	public void newCar() throws IOException {
		car = new Car();
		FacesContext.getCurrentInstance().getExternalContext().redirect("create.xhtml?faces-redirect=true");
	}

	public void saveCar() throws IOException{
		carDao.addCar(car);
		FacesContext.getCurrentInstance().getExternalContext().redirect("index2.xhtml?faces-redirect=true");
	}
	
	public void deleteCar(int carId){
		carDao.deleteCar(carId);
	}
	
	public void updateCar(Car car) throws IOException{
	    //CarDao carDao ;
		carDao.updateCar(car);
		FacesContext.getCurrentInstance().getExternalContext().redirect("index2.xhtml?faces-redirect=true");
	}
	
	public String getById(int carId){
		car = carDao.getCarById(carId);
		return "edit";
	}
	
	
	//===GETEER/SETTER==================
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	
}
