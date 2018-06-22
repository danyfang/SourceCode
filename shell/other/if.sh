# !/bin/bash
if [ -e Ticket.pdf ]; then
	echo yes
fi

if [ -e if.sh ]
	then
		echo yes
fi

df -h | grep /dev/disk1 | awk '{print $5}' | cut -d "%" -f1
rate=$(df -h | grep /dev/disk1 | awk '{print $5}' | cut -d "%" -f1)
if [ $rate -ge 60 ]
	then 
		echo 'disk 1 is almost full'
fi
