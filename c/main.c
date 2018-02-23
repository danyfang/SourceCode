#include <stdio.h>
#include "hashtable.c"
/* Main function for testing purpose only */
int main()
{
	hashtable_t *ht = ht_create(1024);
	ht_put(ht, "foo", "bar");
	printf("%s\n", (char*)ht_get(ht, "foo"));
	ht_put(ht, "foo", "rab");
	printf("%s\n", (char*)ht_get(ht, "foo"));
	ht_remove(ht, "foo");
	if(!ht_get(ht, "foo"))
		printf("foo removed\n");

	ht_put(ht, "foo", "bar");
	ht_put(ht, "toto", "titi");

	printf("Listing keys\n");
	char* str[ht->e_num];
	unsigned int i;
	ht_list_keys(ht, str, ht->e_num);
	for(i = 0; i < ht->e_num; i++)
		printf("%s\n", str[i]);
	
	printf("Listing values\n");
	ht_list_values(ht, (void**)str, ht->e_num);
	for(i = 0; i < ht->e_num; i++)
		printf("%s\n", str[i]);

	hash_elem_it it = HT_ITERATOR(ht);
	hash_elem_t* e = ht_iterate(&it);
	while(e != NULL)
	{
		printf("%s = %s \n", e->key, (char*)e->data);
		e = ht_iterate(&it);
	}
	
	printf("Iterating keys\n");
	hash_elem_it it2 = HT_ITERATOR(ht);
	char* k = ht_iterate_keys(&it2);
	while(k != NULL)
	{
		printf("%s\n", k);
		k = ht_iterate_keys(&it2);
	}

	ht_destroy(ht);
	return 0;
}