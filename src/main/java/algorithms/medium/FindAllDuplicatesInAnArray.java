/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Erdem
 */
public class FindAllDuplicatesInAnArray {
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList();
        for(int i = 0; i<nums.length; i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0)
            {
                ret.add(index+1);
            }
            nums[index] = -nums[index];
        }
        return ret;
    }
}
