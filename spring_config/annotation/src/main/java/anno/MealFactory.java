package anno;/*
 * Copyright (c) 2018年06月08日 by XuanWu Wireless Technology Co.Ltd. 
 *             All rights reserved                         
 */

/**
 * @Description
 * @Author <a href="mailto:haosonglin@wxchina.com">songlin.Hao</a>
 * @Date 2018/6/8
 * @Version 1.0.0
 */
public class MealFactory {

    public Meal create(String mealName) {
        if (mealName == null) {
            throw new IllegalArgumentException("Name of the meal is null");
        }
        if ("Margherita".equals(mealName)) {
            return new MargheritaPizza();
        }
        if ("Calzone".equals(mealName)) {
            return new CalzonePizza();
        }
        if ("Tiramisu".equals(mealName)) {
            return new Tiramisu();
        }
        throw new IllegalArgumentException("Unknow meal " + mealName);
    }

}
