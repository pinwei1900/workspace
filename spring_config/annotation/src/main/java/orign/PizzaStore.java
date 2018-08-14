package orign;/*
 * Copyright (c) 2018年06月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/6/8
 * @Version 1.0.0
 */
public class PizzaStore {

    private MealFactory factory = new MealFactory();

    public Meal order(String mealName) {
        return factory.create(mealName);
    }

//    public Meal order(String mealName) {
//        if (mealName == null) {
//            throw new IllegalArgumentException("Name of the meal is null");
//        }
//        if ("Margherita".equals(mealName)) {
//            return new MargheritaPizza();
//        }
//        if ("Calzone".equals(mealName)) {
//            return new CalzonePizza();
//        }
//        if ("Tiramisu".equals(mealName)) {
//            return new Tiramisu();
//        }
//        throw new IllegalArgumentException("Unknow meal " + mealName);
//    }

    public static void main(String[] args) {
        PizzaStore pizzaStore = new PizzaStore();
        Meal meal = pizzaStore.order("Calzone");
        System.out.println("Bill : " + meal.getPrice());
    }

}
