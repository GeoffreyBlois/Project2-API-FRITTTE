package com.revature.frittte.food;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FoodService {
    private FoodDao foodDao;

    @Autowired
    public FoodService(FoodDao foodDao){
        this.foodDao = foodDao;
    }

    public List<Food> findAll(){
        List<Food> foods = (List <Food>) foodDao.findAll();
        return foods;
    }

    public  boolean deleteById(int id){
      foodDao.deleteById(id);
      return true;



    }
    public Food readById(int id){
        Food food = foodDao.findById(id).get();
        return food;

    }




    public boolean validateUsernameNotUsed(int id){
        return foodDao.existsById(id);
    }

    public Food create(Food newFoodItem){
        if(!validateInput(newFoodItem)){ // checking if false
            // TODO: throw - what's this keyword?
            throw new InvalidRequestException("New FoodItem was not validated, either empty String or null values");
        }

        // TODO: Will implement with JDBC (connecting to our database)
        if(validateEmailNotUsed(newFoodItem.getId())){
            throw new InvalidRequestException("newFoodItem is already in use. Please try again with another newFoodItem or login into previous made account.");
        }

        Food persistedFood = foodDao.save(newFoodItem);

        if(persistedFood == null){
            throw new ResourcePersistanceException("newFoodItem was not persisted to the database upon registration");
        }
        return persistedFood;
    }
}