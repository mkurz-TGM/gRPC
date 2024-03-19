package service;

import io.grpc.stub.StreamObserver;
import proto.Request;
import proto.WarehouseGrpc;
import proto.Request;
import warehouse.Product;
import warehouse.WarehouseData;
import warehouse.WarehouseSimulation;

public class WarehouseImpl extends WarehouseGrpc.WarehouseImplBase {
    /*
     * We observe here that some words have an @, these are Annotations.
     * Annotations are used to provide supplement information about a program. We can autogenerate this functions,
     * in Intellij we can use the shortcut ctrl + O to do this.
     * */
    @Override
    public void getData(Request.WarehouseRequest request, StreamObserver<Request.WarehouseData> responseObserver) {
        /* Build a response composed with the constant Request and the name variable from the Request.
         * For example, if the Request is: gRPC the reply will be: "Request gRPC".
         */
        WarehouseSimulation simulation = new WarehouseSimulation();
        WarehouseData warehouseData = simulation.getData(request.getId());

        Request.WarehouseData.Builder warehouseDataBuilder = Request.WarehouseData.newBuilder();
        warehouseDataBuilder.setId(warehouseData.getID());
        warehouseDataBuilder.setName(warehouseData.getName());
        warehouseDataBuilder.setTimestamp(warehouseData.getTimestamp());
        warehouseDataBuilder.setStreet(warehouseData.getStreet());
        warehouseDataBuilder.setCity(warehouseData.getCity());
        warehouseDataBuilder.setCountry(warehouseData.getCountry());
        warehouseDataBuilder.setPlz(warehouseData.getPlz());
        for (Product p : warehouseData.getProductData()) {
            Request.Product.Builder productBuilder = Request.Product.newBuilder();
            productBuilder.setId(p.getId());
            productBuilder.setName(p.getName());
            productBuilder.setCategory(p.getCategory());
            productBuilder.setAmount(p.getAmount());
            productBuilder.setUnit(p.getUnit());
            warehouseDataBuilder.addProductData(productBuilder.build());
        }
        Request.WarehouseData serializedWarehouseData = warehouseDataBuilder.build();

        responseObserver.onNext(serializedWarehouseData);
        responseObserver.onCompleted();
    }
}