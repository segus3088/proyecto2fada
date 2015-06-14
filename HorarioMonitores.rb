#Class HorarioMonitores
    arr = Array.new(3)

    puts "Ingrese datos"
    puts 'Escriba "fin" para terminar'
    arr.each  {|x| arr = gets.chomp}
      #arr << nextline
      if arr == ""
        arr.size == 0
        #break if arr.size == 0
      end
      #break if arr == "fin"
      #break if arr == ""
      #break if arr == nil

    if arr.size == 0
      puts "No puede estar vacío"
    else if arr.size > 1
      puts "Muchos argumentos"
    end
    end
#end
