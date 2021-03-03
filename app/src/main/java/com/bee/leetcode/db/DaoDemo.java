package com.bee.leetcode.db;

import androidx.room.Dao;

import com.bee.leetcode.net.BeanDemo;

import io.reactivex.Completable;
import io.reactivex.Flowable;

/**
 * created by dr_chene on 2021/2/19
 * desc
 */
@Dao
public interface DaoDemo {
    Flowable<BeanDemo> get();
    Completable save(BeanDemo t);
}
