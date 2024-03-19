import grpc
import helloworld_pb2_grpc, helloworld_pb2

def main():
    channel = grpc.insecure_channel('localhost:8999')
    stub = helloworld_pb2_grpc.WarehouseStub(channel)
    response = stub.getData(helloworld_pb2.WarehouseRequest(id="001"))
    print(response)

if __name__ == "__main__":
    main()