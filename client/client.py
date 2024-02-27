import grpc
import helloworld_pb2_grpc, helloworld_pb2

def main():
    channel = grpc.insecure_channel('localhost:8999')
    stub = helloworld_pb2_grpc.GreeterStub(channel)
    response = stub.SayHello(helloworld_pb2.HelloRequest(name="Matthias"))
    print(response)

if __name__ == "__main__":
    main()