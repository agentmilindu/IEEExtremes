
/**
*
* @author Damitha Shamantha
*/

using System;
using System.Collections.Generic;
using System.IO;
class Solution {static Dictionary<string, int> toppings;

        public static int GetCalorie(string topping)
        {
            int value = 0;
            if (toppings.ContainsKey(topping))
            {
                value = toppings[topping];
            }
            return value;
        }

        public static int GetCalorieValue(string[] calories)
        {
            int total = 270;

            for (int i = 0; i < calories.Length; i++)
            {
                total += GetCalorie(calories[i].ToLower());
            }

            return total;
        }

        static void Main(string[] args)
        {
            toppings = new Dictionary<string, int>();

            toppings.Add("anchovies", 50);
            toppings.Add("artichoke", 60);
            toppings.Add("bacon",92);
            toppings.Add("broccoli", 24);
            toppings.Add("cheese", 80);
            toppings.Add("chicken", 30);
            toppings.Add("feta", 99);
            toppings.Add("garlic", 8);
            toppings.Add("ham", 46);
            toppings.Add("jalapeno", 5);
            toppings.Add("meatballs", 120);
            toppings.Add("mushrooms", 11);
            toppings.Add("olives", 25);
            toppings.Add("onions", 11);
            toppings.Add("pepperoni", 80);
            toppings.Add("peppers", 6);
            toppings.Add("pineapple", 21);
            toppings.Add("sausage", 115);
            toppings.Add("spinach", 18);
            toppings.Add("tomatoes", 14);
            toppings.Add("ricotta", 108);

            

            string[] input = Console.ReadLine().ToString().Split(' ');

            int total = 0;
            int length = Convert.ToInt32(input[0]) * 2;
            //Console.WriteLine(length);
            //Console.WriteLine(input.Length);
            for (int i = 0; i <= length; i++)
            {
                if (i % 2 == 0 && i!=0)
                {
                    string[] topping = input[i].Split(',');
                    int topingCalorie = GetCalorieValue(topping);
                    int slice = Convert.ToInt32(input[i - 1]);
                    total += (topingCalorie *slice);
                }
                
            }

            Console.WriteLine("The total calorie intake is {0}", total);

            
        }
}