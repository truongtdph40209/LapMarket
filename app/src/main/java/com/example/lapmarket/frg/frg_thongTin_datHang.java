package com.example.lapmarket.frg;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lapmarket.R;
import com.example.lapmarket.adapter.ChiTietAdapter;
import com.example.lapmarket.adapter.HoaDonAdapter;
import com.example.lapmarket.dao.HoaDonDAO;
import com.example.lapmarket.dao.ThongTinDatHangDAO;
import com.example.lapmarket.model.dathang;
import com.example.lapmarket.model.hoadon;

import java.util.ArrayList;

public class frg_thongTin_datHang extends Fragment {

    ThongTinDatHangDAO thongTinDatHangDAO;
    ArrayList<dathang> list;
    ArrayList<dathang> list1;

    ChiTietAdapter chiTietAdapter;
    RecyclerView recycler_tt_DatHang;
    public frg_thongTin_datHang() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frg_thong_tin_dat_hang, container, false);

        recycler_tt_DatHang = view.findViewById(R.id.recyclerView_thongTin_datHang);
        SearchView searchView = view.findViewById(R.id.search_thongTin_datHang);

        loadData();

        return view;
    }

    public void loadData(){
        thongTinDatHangDAO = new ThongTinDatHangDAO(getContext());
        list = thongTinDatHangDAO.selectThongTinDatHang();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recycler_tt_DatHang.setLayoutManager(linearLayoutManager);
        chiTietAdapter = new ChiTietAdapter(getContext(), list, thongTinDatHangDAO);
        recycler_tt_DatHang.setAdapter(chiTietAdapter);
    }
}