import threading

def thread_job():
    print('this is an added thread, number is %s'%threading.current_thread())

def main():
    added_thread = threading.Thread(target=thread_job)
    added_thread.start()
    
if __name__ == '__main__':
    main()
