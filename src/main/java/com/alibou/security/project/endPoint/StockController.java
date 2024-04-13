package com.alibou.security.project.endPoint;

import com.alibou.security.payload.ResponseModel;
import com.alibou.security.payload.Result;
import com.alibou.security.project.request.TempRequest;
import com.alibou.security.project.request.UpdatePriceRequest;
import com.alibou.security.project.serv.stock.StockServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {


    @Autowired
    StockServ stockServ;

    @PostMapping("/update-item")
    public ResponseEntity<ResponseModel> Update(@RequestBody UpdatePriceRequest request) throws SQLException {
        boolean check= stockServ.isExist(request.getId());
        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        if(!check){
            result.setErrNo(2001);
            result.setErrMessage("Not found");
            responseModel.setResult(result);
            responseModel.setData(null);
            response = new ResponseEntity<>(
                    responseModel, HttpStatus.OK
            );
            return response;
        }
       var st= stockServ.UpdatePrice(request.getCost(), request.getPrice(), request.getId());
        re.setData(st.getSale_price());
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/available")
    public ResponseEntity<ResponseModel> allAvaItems() throws SQLException {

        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        var st= stockServ.getAllItemsAvailable();
        re.setData(st);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }

    @PostMapping("/no-available")
    public ResponseEntity<ResponseModel> allNoAvaItems() throws SQLException {

        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        var st= stockServ.getAllItemsNonAvailable();
        re.setData(st);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
    @PostMapping("/no-price")
    public ResponseEntity<ResponseModel> allNoPriceItems() throws SQLException {

        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        var st= stockServ.getAllItemsWithNoPrice();
        re.setData(st);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
    @PostMapping("/mv-stock")
    public ResponseEntity<ResponseModel> allMvItems() throws SQLException {

        Result result = new Result();
        ResponseModel re = new ResponseModel();
        ResponseModel responseModel = new ResponseModel<>();
        ResponseEntity<ResponseModel> response;

        var st= stockServ.getAllMovements();
        re.setData(st);
        result.setErrNo(0);
        result.setErrMessage("Done");
        re.setResult(result);
        return ResponseEntity.ok(re);
    }
}
